package com.esprit.examen;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Session;
import com.esprit.examen.services.IFormateurService;
import com.esprit.examen.services.ISessionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionTest {
	@Autowired
	ISessionService us;
	@Autowired
	IFormateurService forService;
	private static final Logger l = LogManager.getLogger(ISessionService.class);

	@Test
	public void sessionAddTest() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebut = dateFormat.parse("2022-03-12");
		Date finishTime = Calendar.getInstance().getTime();
		Session session = new Session(1l, dateDebut, finishTime, 0L, "session");
		Formateur f = new Formateur();
		f.setNom("eya");
		f.setPrenom("aouini");
		forService.addFormateur(f);
		session.setFormateur(f);
		assertNotNull(f);
		us.modifierAddSession(session);
		l.info("sesionAdd : " + session);
	}

	@Test
	public void supprimerSessionTest() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date finishTime = dateFormat.parse("2022-03-12");
		Date currentDate = Calendar.getInstance().getTime();
		Session session = new Session(2l, null, finishTime, 0L, "session");
		us.modifierAddSession(session);
		assertTrue((session.getDateFin().compareTo(currentDate)) < 0);
		us.supprimerSession(session);
	}

}