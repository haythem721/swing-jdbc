import transaction.Dao.GestionCompteImpl;
import transaction.Dao.IGestionCompte;
import transaction.entities.Compte;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGestionCompte action=new GestionCompteImpl();
		
		//System.out.println(action.getAllComptes());
		Compte deb=action.getCompte(123456);
		Compte cre=action.getCompte(123459);
		//System.out.println(deb+"   "+cre);
		action.virer(deb, cre, 1000);
		action.getAllComptes().forEach(x->System.out.println(x));

	}

}
