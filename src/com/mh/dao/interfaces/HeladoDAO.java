package com.mh.dao.interfaces;

import com.mh.biz.pojo.Helado;
import java.util.List;

public interface HeladoDAO {

    public Helado getHeladoByPosition(String posicion) throws Exception;

    public void updateHelado(Helado h) throws Exception;

    public List<Helado> getListHelado() throws Exception;

}
