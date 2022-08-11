package reto5.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.vo.ComprasVo;
import reto5.utils.JDBCUtilities;

//Clase que captura los datos de la consulta y la retorna en una lista

public class ComprasDao {

    public List<ComprasVo> listar() throws SQLException{
        List<ComprasVo> respuesta = new ArrayList<ComprasVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;

        //Consulta SQL
        String consulta = "SELECT c.ID_Compra as id, p.constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE c.Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        try{
            stm = conn.prepareStatement(consulta);
            rs = stm.executeQuery();

            while(rs.next()){
                ComprasVo vo = new ComprasVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn !=null){
                conn.close();
            }
        }
        return respuesta;
    }
}
