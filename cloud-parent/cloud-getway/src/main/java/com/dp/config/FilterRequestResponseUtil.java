package com.dp.config;



import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import reactor.core.publisher.Flux;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mazhen
 * @className FilterHeadersUtil

 */
public final class FilterRequestResponseUtil {

  /**
   * spring cloud gateway 获取post请求的body体
   * @param body
   * @return
   */
  public static String resolveBodyFromRequest( Flux<DataBuffer> body){
    AtomicReference<String> bodyRef = new AtomicReference<>();
    // 缓存读取的request body信息
    body.subscribe(dataBuffer -> {
      CharBuffer charBuffer = StandardCharsets.UTF_8.decode(dataBuffer.asByteBuffer());
      DataBufferUtils.release(dataBuffer);
      bodyRef.set(charBuffer.toString());
    });
    //获取request body
    return bodyRef.get();

  }

  /**
   * 读取body内容
   * @param body
   * @return
   */
  public static String resolveBodyFromRequest2( Flux<DataBuffer> body){
    StringBuilder sb = new StringBuilder();

    body.subscribe(buffer -> {
      byte[] bytes = new byte[buffer.readableByteCount()];
      buffer.read(bytes);
      DataBufferUtils.release(buffer);
      String bodyString = new String(bytes, StandardCharsets.UTF_8);
      sb.append(bodyString);
    });
    return formatStr(sb.toString());
  }

  /**
   * 去掉空格,换行和制表符
   * @param str
   * @return
   */
  private static String formatStr(String str){
    if (str != null && str.length() > 0) {
      Pattern p = Pattern.compile("\\s*|\t|\r|\n");
      Matcher m = p.matcher(str);
      return m.replaceAll("");
    }
    return str;
  }
}