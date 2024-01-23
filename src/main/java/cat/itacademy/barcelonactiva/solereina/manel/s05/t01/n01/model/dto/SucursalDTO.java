package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.domain.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class SucursalDTO {
    private static final List<String> PAISOS_UE = new ArrayList<>();
    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    public static List<String> getPaisosUe() {
        return PAISOS_UE;
    }

    public SucursalDTO() {

    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    public void fromSucursal(Sucursal sucursal) {
        pk_SucursalID = sucursal.getPk_SucursalID();
        nomSucursal = sucursal.getNomSucursal();
        paisSucursal = sucursal.getPaisSucursal();

        if (SucursalDTO.getPaisosUe().contains(sucursal.getPaisSucursal())) {
            tipusSucursal = "UE";
        } else {
            tipusSucursal ="Fora UE";
        }
    }

    public Sucursal toSucursal () {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(pk_SucursalID);
        sucursal.setNomSucursal(nomSucursal);
        sucursal.setPaisSucursal(paisSucursal);

        return sucursal;
    }
}
