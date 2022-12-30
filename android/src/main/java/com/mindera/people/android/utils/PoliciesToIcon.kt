package com.mindera.people.android.utils

import com.mindera.people.android.R

object PoliciesToIcon {

    fun getIconToPolicy(idPolicy: Int): Int {
        return if (isCarnival(idPolicy)) R.drawable.ic_carnival
        else if (isCompassionate(idPolicy)) R.drawable.ic_compassionate_leave
        else if (isLearning(idPolicy)) R.drawable.ic_learning
        else if (isVolunteering(idPolicy)) R.drawable.ic_mindera_volunteering
        else if (isTrip(idPolicy)) R.drawable.ic_mindera_trip
        else if (isSickLeave(idPolicy))R.drawable.ic_sick_leave
        else if (isSickDay(idPolicy)) R.drawable.ic_sickday
        else if (isFamily(idPolicy)) R.drawable.ic_family_leave
        else if (isMarriage(idPolicy)) R.drawable.ic_marriage_leave
        else if (isPolitical(idPolicy)) R.drawable.ic_political_or_justice_service
        else if (isStudentLeave(idPolicy)) R.drawable.ic_student_leave
        else if (isProjectTravel(idPolicy)) R.drawable.ic_project_travel
        else if (isUnpaid(idPolicy)) R.drawable.ic_unpaid_leave
        else if (isWorkHome(idPolicy)) R.drawable.ic_work_from_home
        else if (isWorkRemotely(idPolicy)) R.drawable.ic_work_remotely
        else if (isWorkshopDelivery(idPolicy)) R.drawable.ic_workshop_delivery
        else if (isWorkshopPreparation(idPolicy)) R.drawable.ic_workshop
        else if (isParental(idPolicy)) R.drawable.ic_parental_leave
        else if (isVacation(idPolicy)) R.drawable.ic_vacations_pt
        else R.drawable.ic_work_from_home
    }

    private fun isCarnival(idPolicy: Int) = idPolicy == 79377 || idPolicy == 9540
    private fun isCompassionate(idPolicy: Int) = idPolicy == 79374
    private fun isFamily(idPolicy: Int) = idPolicy == 5685
    private fun isLearning(idPolicy: Int) = idPolicy == 5687
    private fun isMarriage(idPolicy: Int) = idPolicy == 16279
    private fun isVolunteering(idPolicy: Int) = idPolicy == 79350
    private fun isTrip(idPolicy: Int) = idPolicy == 66346
    private fun isPolitical(idPolicy: Int) = idPolicy == 79361
    private fun isSickLeave(idPolicy: Int) = idPolicy == 79365
    private fun isSickDay(idPolicy: Int) = idPolicy == 5280
    private fun isStudentLeave(idPolicy: Int) = idPolicy == 5686
    private fun isProjectTravel(idPolicy: Int) = idPolicy == 5688
    private fun isUnpaid(idPolicy: Int) = idPolicy == 45443
    private fun isWorkHome(idPolicy: Int) = idPolicy == 79351
    private fun isWorkRemotely(idPolicy: Int) = idPolicy == 79363
    private fun isWorkshopDelivery(idPolicy: Int) = idPolicy == 79359
    private fun isWorkshopPreparation(idPolicy: Int) = idPolicy == 79353
    private fun isParental(idPolicy: Int) =
        idPolicy == 79355 || idPolicy == 79373 || idPolicy == 5283
    private fun isVacation(idPolicy: Int) =
        idPolicy == 5279 || idPolicy == 79368 || idPolicy == 8953
                || idPolicy == 79352 || idPolicy == 5281 || idPolicy == 79362 || idPolicy == 79375
}

// Not match yet

//id -> 79356
//name -> "Adoption Leave (AL) IND"
//icon ->
//
//id -> 79364
//name -> "Bereavement"
//icon ->
//
//id -> 79372
//name -> "Brazil Bank Holidays"
//icon ->
//
//id -> 79354
//name -> "Casual Leave (CL) IND"
//icon ->
//
//id -> 15221
//name -> "Earned Leave (EL) IND"
//icon ->
//
//id -> 79358
//name -> "Leave during notice period IND"
//icon ->
//
//id -> 79357
//name -> "Leave Without Pay IND"
//icon ->
//
//id -> 40183
//name -> "National Holidays (change) IND"
//icon ->
//
//id -> 15313
//name -> "Religious Holidays IND"
//icon ->
//
//id -> 79376
//name -> "Self-census RO"
//icon ->