package com.mindera.people.timeoff

enum class TimeOffTypes {
    FULL_DAY,
    FIRST_PART_OF_DAY,
    SECOND_PART_OF_DAY,
    ANOTHER;

    companion object {
        fun mapperEnum(data: String): TimeOffTypes = try {
            valueOf(data)
        } catch (exception: IllegalArgumentException) {
            ANOTHER
        }
    }
}

enum class TimeOffStatus {
    APPROVED, ANOTHER;

    companion object {
        fun mapperEnum(data: String): TimeOffStatus = try {
            valueOf(data)
        } catch (exception: IllegalArgumentException) {
            ANOTHER
        }
    }
}
