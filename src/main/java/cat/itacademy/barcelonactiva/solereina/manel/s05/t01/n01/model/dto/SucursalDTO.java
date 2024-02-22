package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.domain.Sucursal;
import jakarta.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SucursalDTO {
    private static final List<String> PAISOS_UE = Arrays.asList("alemanya", "austria", "belgica", "bulgaria",
            "xipre", "croacia", "dinamarca", "eslovaquia", "eslovenia", "espanya", "estonia", "finlandia", "francia",
            "grecia", "hongria", "irlanda", "italia", "letonia", "lituania", "luxemburg", "malta", "paisos baixos",
            "polonia", "portugal", "republica txeca", "romania", "suecia");
    private Integer pk_SucursalID;
    @NotBlank(message = "Aquest camp és obligatori")
    private String nomSucursal;
    @NotBlank(message = "Aquest camp és obligatori")
    private String paisSucursal;
    private String tipusSucursal;

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

    public static SucursalDTO fromSucursal(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());

        if (SucursalDTO.PAISOS_UE.contains(sucursal.getPaisSucursal().toLowerCase())) {
            sucursalDTO.setTipusSucursal("UE");
        } else {
            sucursalDTO.setTipusSucursal("Fora UE");
        }

        return sucursalDTO;
    }

    public static Sucursal toSucursal (SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());

        return sucursal;
    }
}
