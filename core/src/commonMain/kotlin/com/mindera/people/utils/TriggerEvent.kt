package com.mindera.people.utils

sealed class BaseTriggerEvent {
    override fun equals(other: Any?): Boolean = false
    override fun hashCode(): Int = kotlin.random.Random.nextInt()
}

object TriggerEvent : BaseTriggerEvent()
