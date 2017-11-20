**Пароль: uit24slk**

1. Изменить расширение с .apk на .zip
2. С помощью программы dex2jar  преобразовать файл classes.dex из архива sec.zip (п.1) в classes-dex2jar.jar
3. Изменить расширение с .jar на .zip
4. Открыть исходный apk из Android Studio - приложение запускается с activity A
5. Открыть файл исходного кода A.class из полученного в п.3 архива:
```java
 import android.support.v7.app.m;
  public class A extends m{...}
```
Далее находим в исходном коде, что Toast-уведомление:"Успех!" будет показано,если метод a в классе b.class вернет true.
		
6. Открыть файлы a.class,b.class,c.class из полученного архива в проекте в Android Studio
7.  В 
```java
public class b {
    public static boolean a(String var0) {
        if(!b(var0) || (!c(var0) && !d(var0)
						|| !e(var0)) && (!f(var0) || !g(var0))) {
            return false;
        } else {
            return true;
        }
    }
```
хотим чтобы условие было false и соответственно функция вернула true. Такой результат достигается при возврате true из методов b,f,g

```java
private static boolean b(String var0) {
        return var0.endsWith("k");
    }
private static boolean f(String var0) {
        return var0.startsWith(c.c);//"uit2"
    }
private static boolean g(String var0) {
        return var0.length() >= 7 && var0.substring(3, 8).equals(c.d);//c.d="24slk"
    }
```
**То есть пароль должен начинаться на "uit2", заканчиваться на "k", иметь длину >=7 и 3-8 символы должны быть эквивалентны "24slk". 
Пароль "uit24slk" подходит.**
При вводе пароля видим Toast-уведомление: "Успех!"
