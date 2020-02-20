package com.mybatis3.basic;

/**
 * @author Siva
 *
 */
public class MyBatisSqlSessionFactory {
	/*
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return sqlSessionFactory;
	}

	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
	*/

}
