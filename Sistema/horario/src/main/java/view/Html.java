package view;

public class Html {

    public String headComienzo()
    {
        return "<!doctype html>\n" +
                "<html class=\"no-js\" lang=\"en\" dir=\"ltr\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Foundation for Sites</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/foundation.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/app.css\">\n" +
                "</head>";
    }


    public  String headFin()
    {
        return "</html>";
    }

    public  String Scrip(){
        return "<script src=\"/js/vendor/jquery.js\"></script>\n" +
                "    <script src=\"/js/vendor/what-input.js\"></script>\n" +
                "    <script src=\"/js/vendor/foundation.js\"></script>\n" +
                "    <script src=\"/js/app.js\"></script>";
    }

    public String bodyComienzo()
    {
        return "<body>";
    }

    public String bodyFin()
    {
        return "</body>";
    }
}
