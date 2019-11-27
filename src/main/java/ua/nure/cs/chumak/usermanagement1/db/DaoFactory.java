package ua.nure.cs.chumak.usermanagement1.db;

import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public abstract class DaoFactory {
	
	private static final String DAO_FACTORY = "dao.Factory";
	protected static final String USER_DAO = "dao.ua.nure.cs.chumak.usermanagement1.db.UserDao";

	protected static Properties properties;
	
	private static DaoFactory instance;
	
	static {
		properties = new Properties();
		try {
			properties.load(DaoFactory.class.getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public static void init(Properties prop) {
		properties = prop;
		instance = null;
	}
	
	protected DaoFactory() {
		
	}
	
	public abstract UserDao getUserDao();
	
	public static synchronized DaoFactory getInstance() {
		if(instance==null) {
			Class factoryClass;
			try {
				factoryClass = Class.forName(
						properties.getProperty(DAO_FACTORY));
				instance = (DaoFactory) factoryClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return instance;
	}
	protected ConnectionFactory getConnectionFactory() {
		return new ConnectionFactoryImpl(properties);
	}
	
}
