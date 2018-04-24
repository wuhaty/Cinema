package common;

import common.entity.Movie;
import common.util.RequestAndResponseTool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * Created by gump on 2018/4/23.
 */
public class Crawler {

    static String THEATRE = "https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=0";
    static String BT_ENGINE_URL_BUILDER = "http://www.btantt.com/search/%s-first-asc-1";

    public static void main(String argc[]) throws UnsupportedEncodingException {
        String response = RequestAndResponseTool.sendRequstAndGetResponse(THEATRE);
        JSONObject jo = JSONObject.fromObject(response);

        List<Movie> list2=(List<Movie>) JSONArray.toList(jo.getJSONArray("subjects"), Movie.class);

        System.out.printf("####豆瓣%s推荐前二十####\n",new Date().toString());
        for (Movie m:list2) {
            System.out.print(m.getTitle()+'\t');
        }
        System.out.println();

        for (Movie m :list2) {
            System.out.println(m.getTitle());
            String url = String.format(BT_ENGINE_URL_BUILDER, URLEncoder.encode(m.getTitle(),"utf-8"));
            String searchResult = RequestAndResponseTool.sendRequstAndGetResponse(url);
            Document doc = Jsoup.parse(searchResult, "http://www.btantt.com/");
            Elements magnetLinks = doc.select(".search-item .item-bar a[href^=magnet]");

            if (magnetLinks.isEmpty()) System.out.println("暂无可用下载地址!");
            else{
                m.setMagnetLink(magnetLinks.first().attr("href"));
                System.out.println("下载地址:" + m.getMagnetLink());
            }
        }
    }

}
