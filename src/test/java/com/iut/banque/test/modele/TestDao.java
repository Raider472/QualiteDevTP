package com.iut.banque.test.modele;

import com.iut.banque.interfaces.IDao;
import com.iut.banque.modele.Utilisateur;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.regex.Matcher;

public class TestDao {

    @Test
    public void testDaoIsConnected() {
        IDao dao = Mockito.mock(IDao.class);
        Utilisateur utilisateur = Mockito.mock(Utilisateur.class);
        Mockito.when(utilisateur.getUserId()).thenReturn("id");
        Mockito.when(utilisateur.getUserPwd()).thenReturn("pwd");
        Mockito.when(dao.getUserById(Matcher.quoteReplacement(""))).thenReturn(utilisateur);
        Assert.assertEquals(utilisateur.getUserId(), "id");
    }

}
