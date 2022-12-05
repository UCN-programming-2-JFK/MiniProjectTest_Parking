package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.RentalAgreement;

public interface RentalAgreementDao {
	List<RentalAgreement> getAll();
	RentalAgreement getRentalAgreement(int id);
	boolean addRentalAgreement(RentalAgreement newRentalAgreement);
	boolean updateRentalAgreement(RentalAgreement rentalAgreementToUpdate);
	boolean deleteRentalAgreement(int id);

	List<RentalAgreement> getByEmployeeId(int employeeId);
}