package Model.BO;

import Model.BEAN.Huyen;
import Model.BEAN.Post;
import Model.BEAN.Tinh;
import Model.BEAN.XaPhuong;
import Model.DAO.Connect;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Address_BO {
    private static Address_BO instance;

    public static Address_BO getInstance() {
        if (instance == null) {
            instance = new Address_BO();
        }
        return instance;
    }

    public List<Tinh> getAllProv(){
        return Connect.getInstance().getTinh();
    }

    public List<Tinh> getProvByFind(String key) {
        List<Tinh> tinhList = Address_BO.getInstance().getAllProv();
        List<Tinh> list = new ArrayList<>();
        for (Tinh t: tinhList) {
            if(t.getName().toUpperCase().trim().contains(key.toUpperCase().trim())){
                list.add(t);
            }
        }
        return list;
    }

    public List<Huyen> getAllDistrict(String key) {
        return Connect.getInstance().getHuyen(key);
    }


    public List<Huyen> getDistByFind(String key, String IDDistrict) {
        List<Huyen> huyenList = Address_BO.getInstance().getAllDistrict(IDDistrict);
        List<Huyen> list = new ArrayList<>();
        for (Huyen h: huyenList) {
            if(h.getName().toUpperCase().trim().contains(key.toUpperCase().trim())){
                list.add(h);
            }
        }
        return list;
    }

    public List<XaPhuong> getAllCommune(String key) {
        return Connect.getInstance().getXa(key);
    }

    public List<XaPhuong> getCommuneByFind(String key, String idCommune) {
        List<XaPhuong> xaPhuongList = Address_BO.getInstance().getAllCommune(idCommune);
        List<XaPhuong> list = new ArrayList<>();
        for (XaPhuong x: xaPhuongList) {
            if(x.getName().toUpperCase().trim().contains(key.toUpperCase().trim())){
                list.add(x);
            }
        }
        return list;
    }

    public String getIDProvince() {
        return Connect.getInstance().getIDProvince();
    }

    public boolean addProvince(Tinh tinh) {
        return Connect.getInstance().addProvince(tinh);
    }

    public boolean DeleteProvince(String id) {
        return Connect.getInstance().DeleteProvince(id);
    }

    public Tinh getProvinceByID(String idProvince) {
        return Connect.getInstance().getProvinceByID(idProvince);
    }

    public boolean UpdateProvince(String matp, String name, String type, String slug) {
        return Connect.getInstance().UpdateProvince(matp, name, type, slug);
    }

    public List<String> getAllIDProv() {
        return Connect.getInstance().getAllIDProv();
    }

    public String getIDDistrict() {
        return Connect.getInstance().getIDDistrict();
    }

    public boolean addDistrict(Huyen huyen) {
        return Connect.getInstance().addDistrict(huyen);
    }

    public Huyen getDistrictByID(String idDistrict) {
        return Connect.getInstance().getDistrictByID(idDistrict);
    }

    public boolean UpdateDistrict(String maqh, String name, String type, String matp) {
        return Connect.getInstance().UpdateDistrict(maqh, name, type, matp);
    }

    public boolean DeleteDistrict(String id) {
        return Connect.getInstance().DeleteDistrict(id);
    }

    public String getIDCommune() {
        return Connect.getInstance().getIDCommune();
    }

    public boolean addCommune(XaPhuong xaPhuong) {
        return Connect.getInstance().addCommune(xaPhuong);
    }

    public XaPhuong getCommuneByID(String idCommune) {
        return Connect.getInstance().getCommuneByID(idCommune);
    }

    public boolean UpdateCommune(String xaid, String name, String type, String maqh) {
        return Connect.getInstance().UpdateCommune(xaid, name, type, maqh);
    }

    public boolean DeleteCommune(String id) {
        return Connect.getInstance().DeleteCommune(id);
    }

}
