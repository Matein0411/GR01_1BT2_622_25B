package org.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class main {
  public static void main(String[] args) throws Exception {
    String url  = "jdbc:postgresql://trolley.proxy.rlwy.net:30862/railway?sslmode=require";
    String user = "postgres";
    String pass = "nuMTJvXcrxNwkgylGuQqhMRqfUljeMqS";
    try (Connection c = DriverManager.getConnection(url, user, pass)) {
      System.out.println("✅ Conexión OK a Railway");
    }
  }
}
