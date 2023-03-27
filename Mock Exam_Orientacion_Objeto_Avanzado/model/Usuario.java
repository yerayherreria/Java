package mockExam.model;

import java.util.Objects;

public class Usuario {
	private String login;
	
	private String pass;
	
	public Usuario(String login,String pass) {
		super();
		this.login=login;
		this.pass=pass;
	}
	
	public String getLogin() {
		return login;
	}
	
	public boolean setPass(String antigua,String nueva) {
		boolean cambiada=false;
		if (checkPass(antigua)) {
			cambiada=true;
			this.pass=nueva;
		}
		return cambiada;
	}
	
	public boolean checkPass(String contrasennya) {
		boolean existe=false;
		if (this.pass.equals(contrasennya)) {
			existe=true;
		}
		return existe;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(login, pass);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		if (!sonIguales && obj != null && obj instanceof Usuario) {			
			Usuario other = (Usuario) obj;
			sonIguales = Objects.equals(login, other.login) && Objects.equals(pass, other.pass);
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return "Usuario con login " + login + " y contraseña " + pass;
	}

}
