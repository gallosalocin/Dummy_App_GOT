package com.example.technicaltest.domain.models

/**
 * sealed class used to define all DomainExceptions used in Domain. The conversion is made from the Data layer
 */
sealed class DomainException : Exception() {
    sealed class DomainNetworkException(open val domainError: DomainError) : DomainException() {
        data class BadRequest(override val domainError: DomainError) : DomainNetworkException(domainError)
        data class Unauthorized(override val domainError: DomainError) : DomainNetworkException(domainError)
        data class Forbidden(override val domainError: DomainError) : DomainNetworkException(domainError)
        data class NotFound(override val domainError: DomainError) : DomainNetworkException(domainError)
        data class Conflict(override val domainError: DomainError) : DomainNetworkException(domainError)
        data class UnprocessableEntity(override val domainError: DomainError) : DomainNetworkException(domainError)
        data class InternalError(override val domainError: DomainError) : DomainNetworkException(domainError)
    }

//    sealed class DomainFormException(override val message: String) : DomainException() {
//        data class WrongFirstNameFormat(override val message: String) : DomainFormException(message)
//        data class WrongLastNameFormat(override val message: String) : DomainFormException(message)
//        data class WrongEmailFormat(override val message: String) : DomainFormException(message)
//        data class WrongPhoneNumberFormat(override val message: String) : DomainFormException(message)
//        data class WrongIbanFormat(override val message: String) : DomainFormException(message)
//    }
//
//    sealed class DomainDevicePushTokenException(override val message: String) : DomainException() {
//        data class TokenError(override val message: String) : DomainDevicePushTokenException(message)
//        data class TokenEmpty(override val message: String) : DomainDevicePushTokenException(message)
//    }
//
//    sealed class DomainPermissionException(override val message: String) : DomainException() {
//        data class ReportError(override val message: String) : DomainPermissionException(message)
//        data class BackgroundLocationError(override val message: String) : DomainPermissionException(message)
//        data class PermissionPermanentlyDenied(override val message: String) : DomainPermissionException(message)
//    }
//
//    sealed class DomainLocationException(override val message: String) : DomainException() {
//        data class EmptyLocationError(override val message: String) : DomainLocationException(message)
//    }
//
//    sealed class DomainFirebaseChatException : DomainException() {
//        data class FirebaseChatError(override val message: String?) : DomainFirebaseChatException()
//    }
//
//    sealed class DomainStripeException : DomainException() {
//        data class EmptyCardError(override val message: String?) : DomainStripeException()
//        data class CardNotFoundError(override val message: String?) : DomainStripeException()
//    }
}