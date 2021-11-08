package task;

import java.util.HashMap;

public class WebAddressParser {
    private String adress;

    public WebAddressParser(String adress)
    {
        this.adress = adress;
    }

    /*
     *   Создать в пакете task класс согласно описанию:
     * ---------------------------------------------------------------------
     *   Название: WebAddressParser
     *   Смысл: Синтаксический анализатор веб-адресов
     *   Конструкторы:
     *      - принимающий единственный аргумент - строку с некоторым адресом
     *   Публичные методы:
     *      - String getLogin() - возвращает логин
     *      - String getPassword() - возвращает пароль
     *
     *      - boolean isValid() - является ли адрес корректным
     *      - String getHost() - возвращает хост
     *      - String getPort() - возвращает порт
     *      - String getUrl() - возвращает url-путь
     *      - HashMap<String, String> getParameters() - возвращает словарь
     *          параметров с их значениями
     *      - String getFragment() - возвращает якоро
     *   Дополнительно:
     *      - информация о структуре адреса тут
     *          https://ru.wikipedia.org/wiki/URL#Структура_URL
     *      - в случае, если адрес невалиден или некоторый элемент
     *        отсутствует, соответствующие методы возвращают пустой объект
     * ---------------------------------------------------------------------
     *   Набор private членов класса может быть произвольным.
     *   Все поля класса должны быть private
     *   Не должно быть публичных членов класса сверх списка из условия
     */
    public boolean isValid()
    {
        if(adress == null)
            return false;
        if(adress.indexOf(":") < 1 || adress.indexOf(":") + 1 >= adress.length())
            return false;
        return true; // есть что-то до : и после
    }
    public String getScheme()
    {
        String scheme = new String();
        if(!isValid())
            return scheme;
        int end = adress.indexOf(":");
        scheme = adress.substring(0, end);
        return scheme;
    }
    public String getLogin()
    {
        String login = new String();
        if(adress.indexOf("@") < 0 || !isValid())
            return  login;
        int start = adress.indexOf("://") + 3;  // !!! может зайти за границу массива
        int end = adress.indexOf(":", start);
        if(end != -1)
            login = adress.substring(start, end);
        return login;
    }
    public String getPassword()
    {
        String pass = new String();
        if(getLogin().length() == 0)
            return pass;
        int start = adress.indexOf("://");
        start = adress.indexOf(":", start + 3); // !!! может выйти за массив
        int end = adress.indexOf("@");
        pass = adress.substring(start, end);
        return  pass;
    }
    public String getHost()
    {
        String host = new String();
        if(!isValid() || adress.indexOf("//") < 0)
            return host;
        int start = adress.indexOf("@");
        if(start > 0)
            ++start;
        else
            start = adress.indexOf("//") + 2;
        int end = adress.indexOf(":", start);
        if(end < 0)
            end = adress.indexOf("/", start);
        if(end < 0)
            end = adress.length();
        host = adress.substring(start, end);
        return  host;
    }
    public String getPort()
    {
        String port = new String();
        if(getHost().length() < 1)
            return port;
        int start = adress.indexOf(":", adress.indexOf(":") + 1);
        if(start > 0)
            ++start;
        else
            return port;
        int end = adress.indexOf("/", start);
        if(end < 0)
            end = adress.indexOf("?");
        if(end < 0)
            end = adress.indexOf("#");
        if (end < 0)
            end = adress.length();
        port = adress.substring(start, end);
        return  port;
    }
    public String getUrl()  // может и не быть, например mos.ru
    {
        String url = new String();
        if(!isValid())
            return url;
        int start = adress.indexOf(":");
        if(getHost().length() > 0)
            start = adress.indexOf("/", adress.indexOf("://") + 3);
        if(start < 0)
            return url;
        start++;
        int end = adress.indexOf("?");
        if(end < 0)
            end = adress.indexOf("#");
        if (end < 0)
            end = adress.length();
        url = adress.substring(start, end);
        return  url;
    }
    public String getFragment()
    {
        String fragment = new String();
        if(!isValid())
            return fragment;
        int start = adress.indexOf("#");
        if(start < 0)
            return fragment;
        start++;
        fragment = adress.substring(start);
        return  fragment;
    }
    public HashMap<String, String> getParameters()
    {
        HashMap<String, String> dic = new HashMap<String, String>();
        int start = adress.indexOf("?") + 1;
        if(!isValid() || start < 1)
            return  dic;
        // & ; - separators
        String key = new String();
        String value = new String();
        // закончится когда "#" или последний
        int resheto = 0;
        int val_end = adress.indexOf("&");
        do {
            int end = adress.indexOf("=", start);
            key = adress.substring(start, end);
            if (val_end < 0)
                val_end = adress.indexOf(";");
            if (val_end < 0)
                return dic;
            value = adress.substring(end + 1, val_end);
            dic.put(key, value);
            if(adress.indexOf("#") > 0)
            {
                if(val_end + 1 == adress.indexOf("#"))
                    resheto = 1;
            }
        }while (val_end + 1 < adress.length() && resheto == 0);
        return dic;
    }
}
