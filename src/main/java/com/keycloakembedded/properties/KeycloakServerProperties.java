package com.keycloakembedded.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "keycloak.server")
@Component
public class KeycloakServerProperties {
	
	String contextPath = "/auth";
    String realmImportFile = "baeldung-realm.json";
    public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getRealmImportFile() {
		return realmImportFile;
	}

	public void setRealmImportFile(String realmImportFile) {
		this.realmImportFile = realmImportFile;
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	AdminUser adminUser = new AdminUser();

    // getters and setters

    public static class AdminUser {
        String username = "admin";
        String password = "admin";
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

        // getters and setters        
    }
}
