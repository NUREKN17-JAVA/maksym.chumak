package ua.nure.cs.chumak.usermanagement1.db;

import java.sql.Connection;

public interface ConnectionFactory {
	Connection createConnection() throws DatabaseException;
	
}
