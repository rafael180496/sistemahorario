package com.horario.upoli.horario.view.componentes;

public  class Footer extends  Html {
    private static final String footer="</main><footer class=\"page-footer teal\">\n" +
            "        <div class=\"container\">\n" +
            "            <div class=\"row\">\n" +
            "                <div class=\"col l6 s12\">\n" +
            "                    <h5 class=\"white-text\">Upoli</h5>\n" +
            "                    <p class=\"grey-text text-lighten-4\">Sistema creado para la administracion de Horarios de Clases.</p>\n" +
            "                </div>  \n" +
            "        </div>\n" +
            "        <div class=\"footer-copyright\">\n" +
            "            <div class=\"container\">\n" +
            "                 Evaluacion de Sistema 2017\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </footer>";

    public static String getFooter() {
        return footer;
    }
}
