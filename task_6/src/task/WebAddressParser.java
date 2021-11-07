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
        return false;
    }
    public String getScheme()
    {
        String scheme = new String();
        int end = adress.indexOf(":");  // возможно "://"
        if(end > 0)
            scheme = adress.substring(0, end);
        return scheme;
    }
    public String getLogin()
    {
        String login = new String();
        return  login;
    }
    public String getPassword()
    {
        String login = new String();
        return  login;
    }
    public String getHost()
    {
        String login = new String();
        return  login;
    }
    public String getPort()
    {
        String login = new String();
        return  login;
    }
    public String getUrl()
    {
        String login = new String();
        return  login;
    }
    public String getFragment()
    {
        String login = new String();
        return  login;
    }
    public HashMap<String, String> getParameters()
    {
        HashMap<String, String> dic = new HashMap<String, String>();
        return  dic;
    }
}
