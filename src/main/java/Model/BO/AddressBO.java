package Model.BO;

import Model.BEAN.*;
import Model.DAO.Connect;

import java.util.ArrayList;
import java.util.List;

public class AddressBO {
    private static AddressBO instance;

    public static AddressBO getInstance() {
        if (instance == null) {
            instance = new AddressBO();
        }
        return instance;
    }
    public List<Tinh> getTinh(){
        return Connect.getInstance().getTinh();
    }
    public List<Huyen> getHuyen(String idTinh){
        return Connect.getInstance().getHuyen(idTinh);
    }
    public List<XaPhuong> getXa(String idHuyen) {
        return Connect.getInstance().getXa(idHuyen);
    }
}
