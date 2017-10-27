package view;

public class Html {

    public String headComienzo()
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Document</title>\n" +
                "</head>";
    }


    public  String headFin()
    {
        return "</html>";
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
