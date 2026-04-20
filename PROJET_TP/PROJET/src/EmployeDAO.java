import java.sql.*;
import java.util.*;

public class EmployeDAO {

    public void save(Employe etudiant) throws Exception {

        String sql = "INSERT INTO employes VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = DBConnection.getInstance().prepareStatement(sql);

        ps.setInt(1, etudiant.id);
        ps.setString(2, etudiant.nom);
        ps.setString(3, etudiant.email);
        ps.setString(4, etudiant.departement);
        ps.setDate(5, java.sql.Date.valueOf(etudiant.dateEmbauche));

        ps.executeUpdate();
    }

    public Map<String, Double> getMasseSalarialeParDept() throws Exception {

        Map<String, Double> map = new HashMap<>();

        String sql = "SELECT departement, SUM(salaire_net) FROM employes GROUP BY departement";

        Statement st = DBConnection.getInstance().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            map.put(rs.getString(1), rs.getDouble(2));
        }

        return map;
    }
}