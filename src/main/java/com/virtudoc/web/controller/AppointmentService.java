package com.virtudoc.web.controller;

import com.virtudoc.web.entity.Appointment;
import com.virtudoc.web.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repo;

    //List all appointments - for admins
    public List<Appointment> listAll() {
        return (List<Appointment>) repo.findAll();
    }

    //List customer appointments, performs query using current user's name
    public List<Appointment> listCustomerAppointments(String patientName) {
        return (List<Appointment>) repo.listCustomerAppointments(patientName);
    }

    //List doctor appointments, performs query using current user's name
    public List<Appointment> listDoctorAppointments(String doctorName) {
        return (List<Appointment>) repo.listDoctorAppointments(doctorName);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }


}
