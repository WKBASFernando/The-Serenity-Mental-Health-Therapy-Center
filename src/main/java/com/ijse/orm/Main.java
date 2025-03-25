package com.ijse.orm;

import com.ijse.orm.config.FactoryConfiguration;
import com.ijse.orm.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        TherapySession therapySession1 = new TherapySession();
        therapySession1.setId("TS001");
        therapySession1.setDate("2025-03-25");
        therapySession1.setTime("02.00 pm");

        TherapySession therapySession2 = new TherapySession();
        therapySession2.setId("TS002");
        therapySession2.setDate("2025-03-24");
        therapySession2.setTime("04.00 pm");

        TherapyProgram therapyProgram1 = new TherapyProgram();
        therapyProgram1.setId("MT1001");
        therapyProgram1.setName("Cognitive Behavioral Therapy");
        therapyProgram1.setDuration("12 weeks");
        therapyProgram1.setFee(80000.0);

        TherapyProgram therapyProgram2 = new TherapyProgram();
        therapyProgram2.setId("MT1002");
        therapyProgram2.setName("Mindfulness-Based Stress Reduction");
        therapyProgram2.setDuration("8 weeks");
        therapyProgram2.setFee(50000.0);

        Therapist therapist = new Therapist();
        therapist.setId("TE001");
        therapist.setName("Jack Fernando");
        therapist.setAvailability("Available");
        therapist.setDescription("No Description");

        List<TherapyProgram> programs = new ArrayList<>();
        programs.add(therapyProgram1);
        programs.add(therapyProgram2);

        List<TherapySession> therapySessions = new ArrayList<TherapySession>();
        therapySessions.add(therapySession1);
        therapySessions.add(therapySession2);

        Patient patient = new Patient();
        patient.setId("P001");
        patient.setName("John Doe");
        patient.setAge(40);
        patient.setGender("Male");
        patient.setPhoneNumber("0771234567");
        patient.setAddress("Colombo");
        patient.setEmail("john.doe@gmail.com");

        List<Patient> patients = new ArrayList<>();
        patients.add(patient);

        Payment payment = new Payment();
        payment.setId("PA001");
        payment.setAmount(5000.00);
        payment.setPaymentDate("2025-03-25");
        payment.setPatient(patient);

        therapySession1.setPatient(patient);
        therapySession2.setPatient(patient);
        therapySession1.setTherapist(therapist);
        therapySession2.setTherapist(therapist);

        therapist.setTherapyProgram(therapyProgram1);

//        patient.setPrograms(programs);
        therapyProgram1.setPatients(patients);
        therapyProgram2.setPatients(patients);



        session.persist(therapySession1);
        session.persist(therapySession2);
        session.persist(patient);
        session.persist(payment);
        session.persist(therapist);
        session.persist(therapyProgram1);
        session.persist(therapyProgram2);

        transaction.commit();
        session.close();
    }
}