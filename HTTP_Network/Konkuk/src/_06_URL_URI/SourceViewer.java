package _06_URL_URI;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

// 웹 페이지 다운로드하기
public class SourceViewer {
    public static void main(String args[]) {
        if (args.length > 0) {
            InputStream in = null;

            try {
                URL u = new URL(args[0]); // 먼저 읽어들이려는 URL을 설정한다.
                in = u.openStream();

                in = new BufferedInputStream(in); // 입력의 성능을 버퍼를 통해 높인다.
                Reader r = new InputStreamReader(in); // InputStream을 Reader로 연결한다. (chain)
                int c ;
                while ((c = r.read()) != -1) {  // 끝나기 전까지 계속 읽어들인다.
                    System.out.print((char) c); // 바로 콘솔에 출력한다.
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {}
                }
            }
        }
    }
}