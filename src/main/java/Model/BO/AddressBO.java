package Model.BO;

import Model.BEAN.*;
import Model.DAO.Connect;
import Model.DAO.ConnectAdmin;

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

    public List<Tinh> getTinh() {
        return Connect.getInstance().getTinh();
    }

    public List<Huyen> getHuyen(String idTinh) {
        return Connect.getInstance().getHuyen(idTinh);
    }

    public List<XaPhuong> getXa(String idHuyen) {
        return Connect.getInstance().getXa(idHuyen);
    }


    public List<Tinh> getAllProv() {
        return Connect.getInstance().getTinh();
    }

    public List<Tinh> getProvByFind(String key) {
        List<Tinh> tinhList = AddressBO.getInstance().getAllProv();
        List<Tinh> list = new ArrayList<>();
        for (Tinh t : tinhList) {
            if (t.getName().toUpperCase().trim().contains(key.toUpperCase().trim())) {
                list.add(t);
            }
        }
        return list;
    }

    public List<Huyen> getAllDistrict(String key) {
        return Connect.getInstance().getHuyen(key);
    }


    public List<Huyen> getDistByFind(String key, String IDDistrict) {
        List<Huyen> huyenList = AddressBO.getInstance().getAllDistrict(IDDistrict);
        List<Huyen> list = new ArrayList<>();
        for (Huyen h : huyenList) {
            if (h.getName().toUpperCase().trim().contains(key.toUpperCase().trim())) {
                list.add(h);
            }
        }
        return list;
    }

    public List<XaPhuong> getAllCommune(String key) {
        return Connect.getInstance().getXa(key);
    }

    public List<XaPhuong> getCommuneByFind(String key, String idCommune) {
        List<XaPhuong> xaPhuongList = AddressBO.getInstance().getAllCommune(idCommune);
        List<XaPhuong> list = new ArrayList<>();
        for (XaPhuong x : xaPhuongList) {
            if (x.getName().toUpperCase().trim().contains(key.toUpperCase().trim())) {
                list.add(x);
            }
        }
        return list;
    }

    public String getIDProvince() {
        return ConnectAdmin.getInstance().getIDProvince();
    }

    public boolean addProvince(Tinh tinh) {
        return ConnectAdmin.getInstance().addProvince(tinh);
    }

    public boolean DeleteProvince(String id) {
        return ConnectAdmin.getInstance().DeleteProvince(id);
    }

    public Tinh getProvinceByID(String idProvince) {
        return ConnectAdmin.getInstance().getProvinceByID(idProvince);
    }

    public boolean UpdateProvince(String matp, String name, String type, String slug) {
        return ConnectAdmin.getInstance().UpdateProvince(matp, name, type, slug);
    }

    public List<String> getAllIDProv() {
        return ConnectAdmin.getInstance().getAllIDProv();
    }

    public String getIDDistrict() {
        return ConnectAdmin.getInstance().getIDDistrict();
    }

    public boolean addDistrict(Huyen huyen) {
        return ConnectAdmin.getInstance().addDistrict(huyen);
    }

    public Huyen getDistrictByID(String idDistrict) {
        return ConnectAdmin.getInstance().getDistrictByID(idDistrict);
    }

    public boolean UpdateDistrict(String maqh, String name, String type, String matp) {
        return ConnectAdmin.getInstance().UpdateDistrict(maqh, name, type, matp);
    }

    public boolean DeleteDistrict(String id) {
        return ConnectAdmin.getInstance().DeleteDistrict(id);
    }

    public String getIDCommune() {
        return ConnectAdmin.getInstance().getIDCommune();
    }

    public boolean addCommune(XaPhuong xaPhuong) {
        return ConnectAdmin.getInstance().addCommune(xaPhuong);
    }

    public XaPhuong getCommuneByID(String idCommune) {
        return ConnectAdmin.getInstance().getCommuneByID(idCommune);
    }

    public boolean UpdateCommune(String xaid, String name, String type, String maqh) {
        return ConnectAdmin.getInstance().UpdateCommune(xaid, name, type, maqh);
    }

    public boolean DeleteCommune(String id) {
        return ConnectAdmin.getInstance().DeleteCommune(id);
    }

    public List<String> getAddress(String idxa) {
        List<String> address = new ArrayList<>();
        XaPhuong xaPhuong = ConnectAdmin.getInstance().getCommuneByID(idxa);
        address.add(xaPhuong.getXaid());
        Huyen huyen = ConnectAdmin.getInstance().getDistrictByID(xaPhuong.getMaqh());
        address.add(huyen.getMaqh());
        address.add(huyen.getMatp());
        return address;
    }
}
