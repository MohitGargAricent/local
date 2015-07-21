package Simple;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Sample extends SuperSample {
    
    public static final String NUMBER_PATTERN = "([+]?(\\d){4,})";
    
    public static final String CALLER_AND_CALLED_CONDITION = "^(CALLE[RD][\\s]*==[\\s]*)" + NUMBER_PATTERN
            + "([\\s]+AND[\\s]+CALLE[RD][\\s]*==[\\s]*)" + NUMBER_PATTERN + "$";
    
    
   
    
    
    Sample(){
        
    }
    
    Sample(int n){
        
    }
   
    
    public static void main(String[] args) {
    
        Pattern p = Pattern.compile(CALLER_AND_CALLED_CONDITION);
        Matcher m = p.matcher("CALLED     ==     1236 AND CALLER == 5679");
        
        m.matches();
        
        /*
         * System.out.println(m.group(1)); System.out.println(m.group(2));
         * System.out.println(m.group(3)); System.out.println(m.group(4));
         * System.out.println(m.group(5)); System.out.println(m.group(6));
         */
        
        // String uri = "www.hemant.com/api/v1/12345/rr/qwert";
        
        // System.out.println(uri.replaceFirst("rr/.*", "ss"));
        
        String uuid = "123456711118";
        
        String requestURI = "msgtelrouting/api/v1/customers/" + uuid + "/asd"
                ;
        
        //System.out.println("A:"+requestURI.matches(".*msgtelrouting/api/v.+/customers/?"));
        
        Pattern pattern = Pattern.compile(".*msgtelrouting/api/v.+/customers/(.+)/asd/?");
        Matcher matcher = pattern.matcher(requestURI);
        if (matcher.matches()) {
            //System.out.println(matcher.group(0));
            //System.out.println(matcher.group(1));
            //System.out.println(matcher.group(2));
            //System.out.println(matcher.group(3));
        }
        
        //fun(1);
        //fun(1, "php", null, null);
        //fun(1, new String[]{null, null});
        
        
        StringBuilder bd = new StringBuilder();
        bd.append((String)null);
        
       // Map<String, Object> map = new HashMap<String, Object>(2);
        
        //System.out.println(map.size());
        
        //cml();
        
        
        //String number = "1234";
        
        //System.out.println(validateRegEx(number, "([+]?(\\d){4,})"));
        
       // System.out.println(getConcatenatedString("a", "b", 1, 2.3, new StringBuilder("zzz")));
        
        URI uri = URI.create("/gh@asd");
        
        //System.out.println("[" + uri + "]");
        
        Sample sample = new Sample(2);
        sample.getMap().put("3", "THREE");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("4", "four");
        sample.getMap().putAll(map2);
        System.out.println(sample.getMap().toString());
        
    }
    
    public static String getConcatenatedString(Object... args) {
        
        return StringUtils.join(args, null);
    }
    
    public static void cml() {
        
        String storageURL = "http://192.168.60.172:8080/v1/AUTH_system/msgtelrouting-radical/";
        String targetWAV[] = { "a.wav", "b.wav", "c.wav", "d.wav", "e.wav" };
        
        StringBuilder cmlResponse = new StringBuilder("{\n    ")
        .append("\"instructions\": [\n");
        
        for (String wav : targetWAV) {
            cmlResponse.append("        {\n            \"play\" : { ")
            .append("\"fileURL\" : \"")
            .append(storageURL).append(wav)
            .append("\" }\n        }\n");
        }
        
        cmlResponse.append("    ]\n}");
        
        System.out.println(cmlResponse.toString());
        
        
        
    }
    
    
    public static boolean validateRegEx(final String value, final String regex) {
        
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
    
    public static void fun(int a, String ...strings){
        
        System.out.println(strings.length);
        
        for(String str : strings){
            System.out.println(str);
        }
    }
    
    public static String getStackTrace(final Throwable throwable) {
    
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
   /* 
    private String getRequestBody (final HttpServletRequest request) 
            throws AuthenticationException {
                     
            HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(request);
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                InputStream inputStream = requestWrapper.getInputStream();
                if (inputStream != null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    char[] charBuffer = new char[128];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
                        stringBuilder.append(charBuffer, 0, bytesRead);
                    }
                }
            } catch (IOException ex) {
                throw new AuthenticationException("Error reading the request payload", ex);
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException iox) {
                        // ignore
                    }
                }
            }
         
            return stringBuilder.toString();
        }
    */
}
