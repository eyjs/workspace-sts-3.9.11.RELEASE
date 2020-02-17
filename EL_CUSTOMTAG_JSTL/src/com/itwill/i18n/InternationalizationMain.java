package com.itwill.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/*
 * Internationalization(i18n) 국제화
 */
public class InternationalizationMain {

	public static void main(String[] args) {
		
		Locale currentLocale = Locale.getDefault();
		
		String language = currentLocale.getLanguage();
		String country = currentLocale.getCountry();
		System.out.println(language+"_"+country);
		
		Locale usLocale=new Locale("en", "US");
		Locale jpLocale=new Locale("ja", "JP");
		Locale krLocale=new Locale("ko", "KR");
		Locale cnLocale=new Locale("zh", "CN");
		//Locale locale = usLocale;
		Locale locale = jpLocale;
		//Locale locale = krLocale;
		//Locale locale = cnLocale;
		language=locale.getLanguage();
		country=locale.getCountry();
		
		/*
		 * Locale정보를 이용해서
		 * guest_xx_YY.properties 중하나를 읽어서 
		 * ResourceBundle객체생성
		 */
		ResourceBundle resBundle1 = 
				ResourceBundle.getBundle("com/itwill/i18n/guest",jpLocale);
		System.out.println("----------------locale["+language+"_"+country+"]-----------");
		System.out.println(resBundle1.getString("title.main"));
		System.out.println(resBundle1.getString("title.list"));
		System.out.println(resBundle1.getString("title.view"));
		System.out.println(resBundle1.getString("title.write"));
		System.out.println(resBundle1.getString("write.label.name"));
		System.out.println(resBundle1.getString("write.label.email"));
		System.out.println(resBundle1.getString("write.label.homepage"));
		System.out.println(resBundle1.getString("write.label.title"));

	}

}
