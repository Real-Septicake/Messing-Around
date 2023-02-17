import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTesting {
    static String test = "https:\u002F\u002F64.media.tumblr.com\u002F68f56dfcea49c683f34005478d0e03d0\u002F2ff41037212174ac-04\u002Fs75x75_c1\u002Fe7f6a012843f430623fe36bda45f357dea016d85.jpg";
    static String regex = "\u002F";

    public static void main(String[] args){
        //Matcher m = Pattern.compile(regex).matcher(test);
        String result = test.replaceAll(regex, "/");
        System.out.print(result);
    }
}
