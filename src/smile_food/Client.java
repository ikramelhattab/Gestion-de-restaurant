/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author user
 */

public class Client {

	String nomprenom;
	String pwd;
	String phone;
        String email;
	String addr;



	public Client (String nomprenom, String pwd, String phone, String email, String addr) {
		// TODO Auto-generated constructor stub
		this.nomprenom=nomprenom;
		this.pwd=pwd;
		this.phone=phone;
                this.email=email;
		this.addr=addr;

	}

    public Client(String nomprenom, String phone, String email, String addr) {
        this.nomprenom = nomprenom;
        this.phone = phone;
        this.email = email;
        this.addr = addr;
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
        

    Client(String nomprenom) {
        this.nomprenom=nomprenom; //To change body of generated methods, choose Tools | Templates.
    }



	public String getNomprenom() {
		return nomprenom;
	}

    public String getEmail() {
        return email;
    }



	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}










	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}

    @Override
    public String toString() {
        return nomprenom;
    }


 

}


