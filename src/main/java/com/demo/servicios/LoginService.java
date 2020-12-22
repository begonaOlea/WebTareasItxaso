package com.demo.servicios;

import com.demo.excepciones.LoginException;
import com.demo.producto.*;
import java.util.Collection;
import javax.servlet.http.HttpSession;

public class LoginService {

    public void logIn(String apodo, String contraseña, HttpSession session) throws LoginException {
        //DB ver si existe y coinciden email y contraseña
        Collection<Usuario> usuarios = DB.getUsuarios();
        Usuario usrEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getApodo().equals(apodo)) {
                usrEncontrado = u;
                break;
            }
        }
        if (usrEncontrado == null) {
            // Si el correo no es correcto --> Lanzar exception
            throw new LoginException("Usuario no existe. Introduzca un correo valido.");
        } else {
            if (usrEncontrado.getContraseña().equals(contraseña)) {
                // Si el correo y la contraseña son correcto --> Iniciar sesion
                session.setAttribute("usuario", usrEncontrado);
            } else {
                // Si la constraseña no es correcto --> Lanzar exception
                throw new LoginException("La contraseña no es correcta.");
            }
        }
    }

    public void logOut(HttpSession session) {
        session.invalidate();
    }
}
