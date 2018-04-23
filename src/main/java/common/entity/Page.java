package common.entity;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;

/**
 * Created by gump on 2018/4/23.
 */
public class Page {
    private byte[] content ;
    private String html ;  //网页源码字符串
    private Document doc  ;//网页Dom文档
    private String charset ;//字符编码
    private String url ;//url路径
    private String contentType ;// 内容类型

    public Page(byte[] content , String url , String contentType){
        this.content = content ;
        this.url = url ;
        this.contentType = contentType ;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHtml() {
        if (html != null) {
            return html;
        }
        if (content == null) {
            return null;
        }
        //if(charset==null){
        //    charset = CharsetDetector.guessEncoding(content); // 根据内容来猜测 字符编码
        //}
        try {
            this.html = new String(content, charset);
            return html;
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}