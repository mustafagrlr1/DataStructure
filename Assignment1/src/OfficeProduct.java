/**
 *
 * @author mustafa Gurler
 *
 * This interface presents Products number(constant value) and has been used inside of Product
 * The Tester should change this interface if product model or color has been changed.
 *
 * mn => model number
 *
 * mc => model color
 *
 * oc => office_desk
 *
 * od => office_desk
 *
 * mt => meeting_tables
 *
 * bc => book_cases
 *
 * oca => office_cabinets
 */


public interface OfficeProduct{

    int oc_mn = 7;

    int oc_mc = 5;

    int od_mn = 5;

    int od_mc = 4;

    int mt_mn = 10;

    int mt_mc = 4;

    int bc_mn = 12;

    int oca_mn = 12;

}
