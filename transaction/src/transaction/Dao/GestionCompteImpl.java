package transaction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transaction.entities.Compte;

public class GestionCompteImpl implements IGestionCompte {

	Connection c = SingletonConnection.getInstance();

	@Override
	public void virer(Compte c1, Compte c2, double montant) {

		try {
			PreparedStatement ps;
			c.setAutoCommit(false);
			ps = c.prepareStatement("update compte set solde=? where code=?");
			ps.setDouble(1, c2.getSolde() + montant);
			ps.setInt(2, c2.getNumCompte());
			ps.executeUpdate();
			if(c1.getSolde()<montant) throw new SoldeInsuffisantException("solde insuffisant");
				
			ps = c.prepareStatement("update compte set solde=? where code=?");
			ps.setDouble(1, c1.getSolde() - montant);
			ps.setInt(2, c1.getNumCompte());
			ps.executeUpdate();

			c.commit();
		} catch (SQLException  |SoldeInsuffisantException e) {

			try {
				System.out.println(e.getMessage());
				c.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	@Override
	public Compte getCompte(int code) {
		Compte cc = null;
		try {
			PreparedStatement ps = c.prepareStatement("select * from compte where code=?");
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cc = new Compte(rs.getInt(1), rs.getDouble(2));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cc;

	}

	@Override
	public List<Compte> getAllComptes() {
		List<Compte> liste = new ArrayList<>();

		try {
			PreparedStatement ps = c.prepareStatement("select * from compte");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Compte c = new Compte(rs.getInt(1), rs.getDouble(2));

				liste.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;

	}

}
