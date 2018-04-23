package common;

import common.entity.Movie;
import common.util.RequestAndResponseTool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by gump on 2018/4/23.
 */
public class Crawler {

    static String THEATRE = "https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=0";

    public static void main(String argc[]){
        String response = RequestAndResponseTool.sendRequstAndGetResponse(THEATRE);
        System.out.println(response);
        JSONObject jo = JSONObject.fromObject(response);

        List<Movie> list2=(List<Movie>) JSONArray.toList(jo.getJSONArray("subjects"), Movie.class);
        for (Movie m :list2) {
            System.out.println(m.getTitle());
        }
    }

}
