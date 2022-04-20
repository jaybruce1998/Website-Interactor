import java.io.*;
import java.net.URL;
import java.util.HashMap;
public class GetKanji
{
    private static String urlContent(String URL)
    {
        InputStreamReader i=null;
        String r="";
        try
        {
            i=new InputStreamReader(new URL(URL).openStream());
            BufferedReader b=new BufferedReader(i);
            for(String l=b.readLine(); l!=null; l=b.readLine())
                r+=l;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                i.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return r;
    }
    public static void main(String[] args) {
        String[] kanji=new String[2200];
        HashMap<String, String> map=new HashMap<>();
        String[] lines=urlContent("https://hochanh.github.io/rtk/rtk1-v6/index.html").split("<h3>");
        for(int i=0; i<2200; i++)
        {
            kanji[i]=lines[i+1].split(" ")[2].split("/")[1];
            String c=urlContent("https://hochanh.github.io/rtk/"+kanji[i]+"/index.html");
            System.out.println(kanji[i]+": "+c);
        }
    }
}