package com.example.technicaltest.data.remote.models.exceptions

import com.example.technicaltest.data.remote.models.dto.error.ErrorDto
import com.example.technicaltest.data.remote.models.mapper.DomainExceptionConvertible
import com.example.technicaltest.domain.models.DomainException
import com.example.technicaltest.domain.models.DomainException.DomainNetworkException
import java.net.HttpURLConnection

private const val HTTP_UNPROCESSABLE_ENTITY = 422

/**
 * sealed class that represent all DataException that could be fired from data layer to domain layer
 */
sealed class DataException : Exception(), DomainExceptionConvertible

    data class DataNetworkException(val code: Int, val errorDto: ErrorDto) : DataException() {
        override val message: String = errorDto.message

        override fun toDomain(): DomainException =
            when (code) {
                HttpURLConnection.HTTP_BAD_REQUEST -> DomainNetworkException.BadRequest(errorDto.toDomain())
                HttpURLConnection.HTTP_UNAUTHORIZED -> DomainNetworkException.Unauthorized(errorDto.toDomain())
                HttpURLConnection.HTTP_FORBIDDEN -> DomainNetworkException.Forbidden(errorDto.toDomain())
                HttpURLConnection.HTTP_NOT_FOUND -> DomainNetworkException.NotFound(errorDto.toDomain())
                HttpURLConnection.HTTP_CONFLICT -> DomainNetworkException.Conflict(errorDto.toDomain())
                HTTP_UNPROCESSABLE_ENTITY -> DomainNetworkException.UnprocessableEntity(errorDto.toDomain())
                else -> DomainNetworkException.InternalError(errorDto.toDomain())
            }
    }

//    data class DataAPIDecodeException(override val message: String) : DataException() {
//        override fun toDomain(): DomainException =
//            DomainNetworkException.InternalError(DomainError((message)))
//    }
//
//    sealed class DataThirdPartyLibraryException(override val message: String) : DataException() {
//        data class FirebaseMessagingServiceError(override val message: String) : DataThirdPartyLibraryException(message)
//        data class FirebaseMessagingEmptyTokenError(override val message: String) : DataThirdPartyLibraryException(message)
//
//        override fun toDomain(): DomainException =
//            when (this) {
//                is FirebaseMessagingServiceError -> DomainDevicePushTokenException.TokenError(message)
//                is FirebaseMessagingEmptyTokenError -> DomainDevicePushTokenException.TokenEmpty(message)
//            }
//    }
//
//    sealed class DataPermissionException(override val message: String) : DataException() {
//        data class ReportError(override val message: String) : DataPermissionException(message)
//        data class PermissionPermanentlyDenied(override val message: String) : DataPermissionException(message)
//
//        override fun toDomain(): DomainException =
//            when (this) {
//                is ReportError -> DomainPermissionException.ReportError(message)
//                is PermissionPermanentlyDenied -> DomainPermissionException.PermissionPermanentlyDenied(message)
//            }
//    }
//
//    sealed class DataUserLocationException(override val message: String) : DataException() {
//        data class EmptyLocationError(override val message: String) : DataUserLocationException(message)
//
//        override fun toDomain(): DomainException =
//            when (this) {
//                is EmptyLocationError -> DomainLocationException.EmptyLocationError(message)
//            }
//    }
//
//    sealed class DataFirebaseChatException(override val message: String) : DataException() {
//        data class FirebaseChatError(override val message: String) : DataFirebaseChatException(message)
//
//        override fun toDomain(): DomainException =
//            DomainFirebaseChatException.FirebaseChatError(message)
//    }
//
//    sealed class DataStripeException(override val message: String) : DataException() {
//        data class EmptyCardError(override val message: String) : DataStripeException(message)
//        data class CardNotFoundError(override val message: String) : DataStripeException(message)
//        data class NullBodyError(override val message: String) : DataStripeException(message)
//        data class TooLargeBodyError(override val message: String) : DataStripeException(message)
//
//        override fun toDomain(): DomainException =
//            when (this) {
//                is EmptyCardError -> DomainStripeException.EmptyCardError(message)
//                is CardNotFoundError -> DomainStripeException.CardNotFoundError(message)
//                is NullBodyError -> DomainNetworkException.InternalError(DomainError(message))
//                is TooLargeBodyError -> DomainNetworkException.InternalError(DomainError(message))
//            }
//    }
