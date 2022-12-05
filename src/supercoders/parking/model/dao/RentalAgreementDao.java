package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.RentalAgreement;

public interface RentalAgreementDao {
	List<RentalAgreement> getAll();
	RentalAgreement getRentalAgreement(int id);
	int addRentalAgreement(RentalAgreement newRentalAgreement);
	boolean updateRentalAgreement(RentalAgreement rentalAgreementToUpdate);
	boolean deleteRentalAgreement(int id);

	List<RentalAgreement> getByEmployeeInitials(String employeeInitials);
}