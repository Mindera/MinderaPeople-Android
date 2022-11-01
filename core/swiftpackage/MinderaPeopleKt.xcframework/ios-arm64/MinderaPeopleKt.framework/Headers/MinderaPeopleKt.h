#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class MPKKoin_coreKoin, MPKAuthenticationKt, MPKUser, MPKAuthState, MPKHomeKt, MPKHomeState, MPKMinderaPeopleAppKt, MPKKotlinx_coroutines_coreCoroutineDispatcher, MPKViewModel, MPKBaseTriggerEvent, MPKTriggerEvent, MPKUiState<__covariant T>, MPKUiStateError, MPKKotlinNothing, MPKUiStateIdle, MPKUiStateLoading, MPKUiStateSuccess<T>, MPKKermitLogger, MPKSettingsStorageImplCompanion, MPKKotlinThrowable, MPKAuthStateAuthError, MPKAuthStateAuthSuccess, MPKAuthStateIdle, MPKAuthStateUserCleared, MPKStateViewModel<A, S>, MPKAuthViewModelAction, MPKAuthViewModelActionAuthenticate, MPKAuthViewModelActionClear, MPKHomeStateAuthenticationState, MPKHomeStateIdle, MPKHomeStateLoading, MPKHomeViewModelAction, MPKHomeViewModelActionAuthenticate, MPKHomeViewModelActionUserAuthenticationUpdate, MPKUserCompanion, MPKUserRepositoryImplCompanion, MPKKoin_coreLockable, MPKKoin_coreScope, MPKKoin_coreParametersHolder, MPKKotlinLazyThreadSafetyMode, MPKKotlinArray<T>, MPKKoin_coreLogger, MPKKotlinx_datetimeMonth, MPKKotlinx_datetimeLocalDateCompanion, MPKKotlinx_datetimeLocalDate, MPKKotlinx_datetimeDayOfWeek, MPKKoin_coreKoinApplication, MPKKoin_coreModule, MPKKotlinRegex, MPKKoin_coreInstanceRegistry, MPKKoin_corePropertyRegistry, MPKKoin_coreScopeRegistry, MPKKotlinAbstractCoroutineContextElement, MPKKotlinx_coroutines_coreCoroutineDispatcherKey, MPKKotlinException, MPKKotlinRuntimeException, MPKKotlinIllegalStateException, MPKKermitLoggerCompanion, MPKKermitSeverity, MPKKoin_coreParametersHolderCompanion, MPKKotlinEnumCompanion, MPKKotlinEnum<E>, MPKKoin_coreLevel, MPKKoin_coreKoinApplicationCompanion, MPKKoin_coreInstanceFactory<T>, MPKKotlinPair<__covariant A, __covariant B>, MPKKoin_coreScopeDSL, MPKKoin_coreSingleInstanceFactory<T>, MPKKotlinRegexOption, MPKKotlinRegexCompanion, MPKKotlinCancellationException, MPKKoin_coreScopeRegistryCompanion, MPKKotlinAbstractCoroutineContextKey<B, E>, MPKKermitLogWriter, MPKKotlinx_serialization_coreSerializersModule, MPKKotlinx_serialization_coreSerialKind, MPKKoin_coreBeanDefinition<T>, MPKKoin_coreInstanceFactoryCompanion, MPKKoin_coreInstanceContext, MPKKotlinMatchResultDestructured, MPKKotlinIntRange, MPKKoin_coreKind, MPKKoin_coreCallbacks<T>, MPKKotlinMatchGroup, MPKKotlinIntProgressionCompanion, MPKKotlinIntIterator, MPKKotlinIntProgression, MPKKotlinIntRangeCompanion, MPKKotlinx_coroutines_coreAtomicDesc, MPKKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp, MPKKotlinx_coroutines_coreAtomicOp<__contravariant T>, MPKKotlinx_coroutines_coreOpDescriptor, MPKKotlinx_coroutines_coreLockFreeLinkedListNode, MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc, MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc<T>, MPKKotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc<T>;

@protocol MPKKoin_coreKoinComponent, MPKKotlinx_coroutines_coreCoroutineScope, MPKKotlinx_coroutines_coreFlow, MPKKotlinx_coroutines_coreStateFlow, MPKSettingsStorage, MPKMultiplatform_settingsSettings, MPKUserRepository, MPKKotlinx_serialization_coreKSerializer, MPKKoin_coreQualifier, MPKKotlinKClass, MPKKotlinLazy, MPKKoin_coreScopeCallback, MPKKotlinComparable, MPKKotlinx_coroutines_coreJob, MPKKotlinSuspendFunction1, MPKKoin_coreKoinScopeComponent, MPKKotlinCoroutineContextKey, MPKKotlinCoroutineContextElement, MPKKotlinCoroutineContext, MPKKotlinContinuation, MPKKotlinContinuationInterceptor, MPKKotlinx_coroutines_coreRunnable, MPKKotlinx_coroutines_coreFlowCollector, MPKKotlinx_coroutines_coreSharedFlow, MPKKermitLoggerConfig, MPKKotlinx_serialization_coreEncoder, MPKKotlinx_serialization_coreSerialDescriptor, MPKKotlinx_serialization_coreSerializationStrategy, MPKKotlinx_serialization_coreDecoder, MPKKotlinx_serialization_coreDeserializationStrategy, MPKKotlinKDeclarationContainer, MPKKotlinKAnnotatedElement, MPKKotlinKClassifier, MPKKotlinIterator, MPKKotlinMatchResult, MPKKotlinSequence, MPKKotlinx_coroutines_coreChildHandle, MPKKotlinx_coroutines_coreChildJob, MPKKotlinx_coroutines_coreDisposableHandle, MPKKotlinx_coroutines_coreSelectClause0, MPKKotlinFunction, MPKKotlinx_serialization_coreCompositeEncoder, MPKKotlinAnnotation, MPKKotlinx_serialization_coreCompositeDecoder, MPKKotlinMatchGroupCollection, MPKKotlinx_coroutines_coreParentJob, MPKKotlinx_coroutines_coreSelectInstance, MPKKotlinSuspendFunction0, MPKKotlinx_serialization_coreSerializersModuleCollector, MPKKotlinIterable, MPKKotlinCollection, MPKKotlinClosedRange;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface MPKBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface MPKBase (MPKBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface MPKMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface MPKMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorMPKKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface MPKNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface MPKByte : MPKNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface MPKUByte : MPKNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface MPKShort : MPKNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface MPKUShort : MPKNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface MPKInt : MPKNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface MPKUInt : MPKNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface MPKLong : MPKNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface MPKULong : MPKNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface MPKFloat : MPKNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface MPKDouble : MPKNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface MPKBoolean : MPKNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((swift_name("Koin_coreKoinComponent")))
@protocol MPKKoin_coreKoinComponent
@required
- (MPKKoin_coreKoin *)getKoin __attribute__((swift_name("getKoin()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthenticationKt")))
@interface MPKAuthenticationKt : MPKBase <MPKKoin_coreKoinComponent>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)authenticationKt __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKAuthenticationKt *shared __attribute__((swift_name("shared")));
- (void)authenticateUser:(MPKUser *)user __attribute__((swift_name("authenticate(user:)")));
- (void)stateObservationCallback:(void (^)(MPKAuthState *))callback __attribute__((swift_name("stateObservation(callback:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeKt")))
@interface MPKHomeKt : MPKBase <MPKKoin_coreKoinComponent>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)homeKt __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKHomeKt *shared __attribute__((swift_name("shared")));
- (void)setUserUser:(MPKUser *)user __attribute__((swift_name("setUser(user:)")));
- (void)stateObservationCallback:(void (^)(MPKHomeState *))callback __attribute__((swift_name("stateObservation(callback:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MinderaPeopleAppKt")))
@interface MPKMinderaPeopleAppKt : MPKBase <MPKKoin_coreKoinComponent>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)minderaPeopleAppKt __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKMinderaPeopleAppKt *shared __attribute__((swift_name("shared")));
- (void)start __attribute__((swift_name("start()")));
- (void)stop __attribute__((swift_name("stop()")));
@end;

__attribute__((swift_name("BaseTriggerEvent")))
@interface MPKBaseTriggerEvent : MPKBase
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@end;

__attribute__((swift_name("ViewModel")))
@interface MPKViewModel : MPKBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (readonly) MPKKotlinx_coroutines_coreCoroutineDispatcher *ioDispatcher __attribute__((swift_name("ioDispatcher")));
@property (readonly) MPKKotlinx_coroutines_coreCoroutineDispatcher *mainDispatcher __attribute__((swift_name("mainDispatcher")));
@property (readonly) id<MPKKotlinx_coroutines_coreCoroutineScope> scope __attribute__((swift_name("scope")));
@end;

__attribute__((swift_name("StateViewModel")))
@interface MPKStateViewModel<A, S> : MPKViewModel
- (instancetype)initWithInitialState:(S _Nullable)initialState __attribute__((swift_name("init(initialState:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)enqueueActionAction:(A _Nullable)action __attribute__((swift_name("enqueueAction(action:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)processActionAction:(A _Nullable)action latestState:(S _Nullable)latestState completionHandler:(void (^)(id<MPKKotlinx_coroutines_coreFlow> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("processAction(action:latestState:completionHandler:)")));
@property (readonly) id<MPKKotlinx_coroutines_coreStateFlow> state __attribute__((swift_name("state")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TriggerEvent")))
@interface MPKTriggerEvent : MPKBaseTriggerEvent
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)triggerEvent __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKTriggerEvent *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("UiState")))
@interface MPKUiState<__covariant T> : MPKBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiStateError")))
@interface MPKUiStateError : MPKUiState<MPKKotlinNothing *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)error __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKUiStateError *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiStateIdle")))
@interface MPKUiStateIdle : MPKUiState<MPKKotlinNothing *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)idle __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKUiStateIdle *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiStateLoading")))
@interface MPKUiStateLoading : MPKUiState<MPKKotlinNothing *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)loading __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKUiStateLoading *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiStateSuccess")))
@interface MPKUiStateSuccess<T> : MPKUiState<T>
- (instancetype)initWithData:(T _Nullable)data __attribute__((swift_name("init(data:)"))) __attribute__((objc_designated_initializer));
- (T _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKUiStateSuccess<T> *)doCopyData:(T _Nullable)data __attribute__((swift_name("doCopy(data:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) T _Nullable data __attribute__((swift_name("data")));
@end;

__attribute__((swift_name("SettingsStorage")))
@protocol MPKSettingsStorage
@required
@property BOOL isOnboarded __attribute__((swift_name("isOnboarded")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SettingsStorageImpl")))
@interface MPKSettingsStorageImpl : MPKBase <MPKSettingsStorage>
- (instancetype)initWithLog:(MPKKermitLogger *)log settings:(id<MPKMultiplatform_settingsSettings>)settings __attribute__((swift_name("init(log:settings:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKSettingsStorageImplCompanion *companion __attribute__((swift_name("companion")));
@property BOOL isOnboarded __attribute__((swift_name("isOnboarded")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SettingsStorageImpl.Companion")))
@interface MPKSettingsStorageImplCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKSettingsStorageImplCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("AuthState")))
@interface MPKAuthState : MPKBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthState.AuthError")))
@interface MPKAuthStateAuthError : MPKAuthState
- (instancetype)initWithError:(MPKKotlinThrowable *)error __attribute__((swift_name("init(error:)"))) __attribute__((objc_designated_initializer));
- (MPKKotlinThrowable *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKAuthStateAuthError *)doCopyError:(MPKKotlinThrowable *)error __attribute__((swift_name("doCopy(error:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKKotlinThrowable *error __attribute__((swift_name("error")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthState.AuthSuccess")))
@interface MPKAuthStateAuthSuccess : MPKAuthState
- (instancetype)initWithUser:(MPKUser *)user __attribute__((swift_name("init(user:)"))) __attribute__((objc_designated_initializer));
- (MPKUser *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKAuthStateAuthSuccess *)doCopyUser:(MPKUser *)user __attribute__((swift_name("doCopy(user:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKUser *user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthState.Idle")))
@interface MPKAuthStateIdle : MPKAuthState
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)idle __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKAuthStateIdle *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthState.UserCleared")))
@interface MPKAuthStateUserCleared : MPKAuthState
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)userCleared __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKAuthStateUserCleared *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthViewModel")))
@interface MPKAuthViewModel : MPKStateViewModel<MPKAuthViewModelAction *, MPKAuthState *>
- (instancetype)initWithUserRepository:(id<MPKUserRepository>)userRepository __attribute__((swift_name("init(userRepository:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithInitialState:(id _Nullable)initialState __attribute__((swift_name("init(initialState:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)authenticateUser:(MPKUser *)user __attribute__((swift_name("authenticate(user:)")));
- (void)clear __attribute__((swift_name("clear()")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)processActionAction:(MPKAuthViewModelAction *)action latestState:(MPKAuthState *)latestState completionHandler:(void (^)(id<MPKKotlinx_coroutines_coreFlow> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("processAction(action:latestState:completionHandler:)")));
@end;

__attribute__((swift_name("AuthViewModel.Action")))
@interface MPKAuthViewModelAction : MPKBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthViewModel.ActionAuthenticate")))
@interface MPKAuthViewModelActionAuthenticate : MPKAuthViewModelAction
- (instancetype)initWithUser:(MPKUser *)user __attribute__((swift_name("init(user:)"))) __attribute__((objc_designated_initializer));
- (MPKUser *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKAuthViewModelActionAuthenticate *)doCopyUser:(MPKUser *)user __attribute__((swift_name("doCopy(user:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKUser *user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthViewModel.ActionClear")))
@interface MPKAuthViewModelActionClear : MPKAuthViewModelAction
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)clear __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKAuthViewModelActionClear *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("HomeState")))
@interface MPKHomeState : MPKBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeState.AuthenticationState")))
@interface MPKHomeStateAuthenticationState : MPKHomeState
- (instancetype)initWithUser:(MPKUser * _Nullable)user error:(MPKKotlinThrowable * _Nullable)error __attribute__((swift_name("init(user:error:)"))) __attribute__((objc_designated_initializer));
- (MPKUser * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKotlinThrowable * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKHomeStateAuthenticationState *)doCopyUser:(MPKUser * _Nullable)user error:(MPKKotlinThrowable * _Nullable)error __attribute__((swift_name("doCopy(user:error:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKKotlinThrowable * _Nullable error __attribute__((swift_name("error")));
@property (readonly) MPKUser * _Nullable user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeState.Idle")))
@interface MPKHomeStateIdle : MPKHomeState
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)idle __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKHomeStateIdle *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeState.Loading")))
@interface MPKHomeStateLoading : MPKHomeState
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)loading __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKHomeStateLoading *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeViewModel")))
@interface MPKHomeViewModel : MPKStateViewModel<MPKHomeViewModelAction *, MPKHomeState *>
- (instancetype)initWithUserRepository:(id<MPKUserRepository>)userRepository __attribute__((swift_name("init(userRepository:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithInitialState:(id _Nullable)initialState __attribute__((swift_name("init(initialState:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)processActionAction:(MPKHomeViewModelAction *)action latestState:(MPKHomeState *)latestState completionHandler:(void (^)(id<MPKKotlinx_coroutines_coreFlow> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("processAction(action:latestState:completionHandler:)")));
- (void)setUserUser:(MPKUser *)user __attribute__((swift_name("setUser(user:)")));
@end;

__attribute__((swift_name("HomeViewModel.Action")))
@interface MPKHomeViewModelAction : MPKBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeViewModel.ActionAuthenticate")))
@interface MPKHomeViewModelActionAuthenticate : MPKHomeViewModelAction
- (instancetype)initWithUser:(MPKUser *)user __attribute__((swift_name("init(user:)"))) __attribute__((objc_designated_initializer));
- (MPKUser *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKHomeViewModelActionAuthenticate *)doCopyUser:(MPKUser *)user __attribute__((swift_name("doCopy(user:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKUser *user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeViewModel.ActionUserAuthenticationUpdate")))
@interface MPKHomeViewModelActionUserAuthenticationUpdate : MPKHomeViewModelAction
- (instancetype)initWithUser:(MPKUser * _Nullable)user error:(MPKKotlinThrowable * _Nullable)error __attribute__((swift_name("init(user:error:)"))) __attribute__((objc_designated_initializer));
- (MPKUser * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKotlinThrowable * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKHomeViewModelActionUserAuthenticationUpdate *)doCopyUser:(MPKUser * _Nullable)user error:(MPKKotlinThrowable * _Nullable)error __attribute__((swift_name("doCopy(user:error:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKKotlinThrowable * _Nullable error __attribute__((swift_name("error")));
@property (readonly) MPKUser * _Nullable user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("User")))
@interface MPKUser : MPKBase
- (instancetype)initWithEmail:(NSString *)email name:(NSString * _Nullable)name __attribute__((swift_name("init(email:name:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKUserCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKUser *)doCopyEmail:(NSString *)email name:(NSString * _Nullable)name __attribute__((swift_name("doCopy(email:name:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *email __attribute__((swift_name("email")));
@property (readonly) NSString * _Nullable name __attribute__((swift_name("name")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("User.Companion")))
@interface MPKUserCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKUserCompanion *shared __attribute__((swift_name("shared")));
- (id<MPKKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("UserRepository")))
@protocol MPKUserRepository
@required
- (void)authenticateUserUser:(MPKUser *)user __attribute__((swift_name("authenticateUser(user:)")));
- (void)clearUser __attribute__((swift_name("clearUser()")));
@property (readonly) MPKUser * _Nullable authenticated __attribute__((swift_name("authenticated")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UserRepositoryImpl")))
@interface MPKUserRepositoryImpl : MPKBase <MPKUserRepository>
- (instancetype)initWithLog:(MPKKermitLogger *)log encryptedSettings:(id<MPKMultiplatform_settingsSettings>)encryptedSettings __attribute__((swift_name("init(log:encryptedSettings:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKUserRepositoryImplCompanion *companion __attribute__((swift_name("companion")));
- (void)authenticateUserUser:(MPKUser *)user __attribute__((swift_name("authenticateUser(user:)")));
- (void)clearUser __attribute__((swift_name("clearUser()")));
@property (readonly) MPKUser * _Nullable authenticated __attribute__((swift_name("authenticated")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UserRepositoryImpl.Companion")))
@interface MPKUserRepositoryImplCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKUserRepositoryImplCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("Koin_coreLockable")))
@interface MPKKoin_coreLockable : MPKBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScope")))
@interface MPKKoin_coreScope : MPKKoin_coreLockable
- (instancetype)initWithScopeQualifier:(id<MPKKoin_coreQualifier>)scopeQualifier id:(NSString *)id isRoot:(BOOL)isRoot _koin:(MPKKoin_coreKoin *)_koin __attribute__((swift_name("init(scopeQualifier:id:isRoot:_koin:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)close __attribute__((swift_name("close()")));
- (id<MPKKoin_coreQualifier>)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (BOOL)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKoin_coreScope *)doCopyScopeQualifier:(id<MPKKoin_coreQualifier>)scopeQualifier id:(NSString *)id isRoot:(BOOL)isRoot _koin:(MPKKoin_coreKoin *)_koin __attribute__((swift_name("doCopy(scopeQualifier:id:isRoot:_koin:)")));
- (void)declareInstance:(id _Nullable)instance qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier secondaryTypes:(NSArray<id<MPKKotlinKClass>> *)secondaryTypes allowOverride:(BOOL)allowOverride __attribute__((swift_name("declare(instance:qualifier:secondaryTypes:allowOverride:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (id _Nullable)getClazz:(id<MPKKotlinKClass>)clazz qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(clazz:qualifier:parameters:)")));
- (id)getQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(qualifier:parameters:)")));
- (NSArray<id> *)getAll __attribute__((swift_name("getAll()")));
- (NSArray<id> *)getAllClazz:(id<MPKKotlinKClass>)clazz __attribute__((swift_name("getAll(clazz:)")));
- (MPKKoin_coreKoin *)getKoin __attribute__((swift_name("getKoin()")));
- (id _Nullable)getOrNullClazz:(id<MPKKotlinKClass>)clazz qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(clazz:qualifier:parameters:)")));
- (id _Nullable)getOrNullQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(qualifier:parameters:)")));
- (id)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (id)getPropertyKey:(NSString *)key defaultValue:(id)defaultValue __attribute__((swift_name("getProperty(key:defaultValue:)")));
- (id _Nullable)getPropertyOrNullKey:(NSString *)key __attribute__((swift_name("getPropertyOrNull(key:)")));
- (MPKKoin_coreScope *)getScopeScopeID:(NSString *)scopeID __attribute__((swift_name("getScope(scopeID:)")));
- (id _Nullable)getSource __attribute__((swift_name("getSource()"))) __attribute__((deprecated("No need to use getSource(). You can an use get() directly.")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (id<MPKKotlinLazy>)injectQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier mode:(MPKKotlinLazyThreadSafetyMode *)mode parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("inject(qualifier:mode:parameters:)")));
- (id<MPKKotlinLazy>)injectOrNullQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier mode:(MPKKotlinLazyThreadSafetyMode *)mode parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("injectOrNull(qualifier:mode:parameters:)")));
- (BOOL)isNotClosed __attribute__((swift_name("isNotClosed()")));
- (void)linkToScopes:(MPKKotlinArray<MPKKoin_coreScope *> *)scopes __attribute__((swift_name("linkTo(scopes:)")));
- (void)registerCallbackCallback:(id<MPKKoin_coreScopeCallback>)callback __attribute__((swift_name("registerCallback(callback:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (void)unlinkScopes:(MPKKotlinArray<MPKKoin_coreScope *> *)scopes __attribute__((swift_name("unlink(scopes:)")));
@property (readonly) NSMutableArray<MPKKoin_coreParametersHolder *> *_parameterStack __attribute__((swift_name("_parameterStack")));
@property id _Nullable _source __attribute__((swift_name("_source")));
@property (readonly) BOOL closed __attribute__((swift_name("closed")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) BOOL isRoot __attribute__((swift_name("isRoot")));
@property (readonly) MPKKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) id<MPKKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@end;

@interface MPKKoin_coreScope (Extensions)
- (id _Nullable)getWithParams:(MPKKotlinArray<id> *)params __attribute__((swift_name("getWith(params:)")));
@end;

__attribute__((swift_name("KotlinComparable")))
@protocol MPKKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDate")))
@interface MPKKotlinx_datetimeLocalDate : MPKBase <MPKKotlinComparable>
- (instancetype)initWithYear:(int32_t)year month:(MPKKotlinx_datetimeMonth *)month dayOfMonth:(int32_t)dayOfMonth __attribute__((swift_name("init(year:month:dayOfMonth:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithYear:(int32_t)year monthNumber:(int32_t)monthNumber dayOfMonth:(int32_t)dayOfMonth __attribute__((swift_name("init(year:monthNumber:dayOfMonth:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKKotlinx_datetimeLocalDateCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(MPKKotlinx_datetimeLocalDate *)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (int32_t)toEpochDays __attribute__((swift_name("toEpochDays()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property (readonly) MPKKotlinx_datetimeDayOfWeek *dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property (readonly) int32_t dayOfYear __attribute__((swift_name("dayOfYear")));
@property (readonly) MPKKotlinx_datetimeMonth *month __attribute__((swift_name("month")));
@property (readonly) int32_t monthNumber __attribute__((swift_name("monthNumber")));
@property (readonly) int32_t year __attribute__((swift_name("year")));
@end;

@interface MPKKotlinx_datetimeLocalDate (Extensions)
- (MPKKotlinx_datetimeLocalDate *)withDayOfMonthDayOfMonth:(int32_t)dayOfMonth __attribute__((swift_name("withDayOfMonth(dayOfMonth:)")));
@property (readonly) MPKKotlinx_datetimeLocalDate *atEndOfMonth __attribute__((swift_name("atEndOfMonth")));
@property (readonly) MPKKotlinx_datetimeLocalDate *nextMonth __attribute__((swift_name("nextMonth")));
@property (readonly) int32_t weekNumber __attribute__((swift_name("weekNumber")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KoinSetupKt")))
@interface MPKKoinSetupKt : MPKBase
+ (MPKKoin_coreKoinApplication *)doInitKoinAppDeclaration:(void (^)(MPKKoin_coreKoinApplication *))appDeclaration __attribute__((swift_name("doInitKoin(appDeclaration:)")));
@property (class, readonly) NSString *ENCRYPTED_STORAGE_NAME __attribute__((swift_name("ENCRYPTED_STORAGE_NAME")));
@property (class, readonly) NSString *STORAGE_NAME __attribute__((swift_name("STORAGE_NAME")));
@property (class, readonly) NSString *encryptedSettings __attribute__((swift_name("encryptedSettings")));
@property (class, readonly) NSString *unencryptedSettings __attribute__((swift_name("unencryptedSettings")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlatformKt")))
@interface MPKPlatformKt : MPKBase
@property (class, readonly) MPKKoin_coreModule *platformModule __attribute__((swift_name("platformModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RegexKt")))
@interface MPKRegexKt : MPKBase
@property (class, readonly) MPKKotlinRegex *emailAddressRegex __attribute__((swift_name("emailAddressRegex")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeneralKt")))
@interface MPKGeneralKt : MPKBase
+ (NSString * _Nullable)getUrlContentUrl:(NSString *)url __attribute__((swift_name("getUrlContent(url:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CoroutinesKt")))
@interface MPKCoroutinesKt : MPKBase
+ (id<MPKKotlinx_coroutines_coreJob>)safeLaunch:(id<MPKKotlinx_coroutines_coreCoroutineScope>)receiver block:(id<MPKKotlinSuspendFunction1>)block __attribute__((swift_name("safeLaunch(_:block:)")));
+ (id<MPKKotlinx_coroutines_coreJob>)safeLaunchIn:(id<MPKKotlinx_coroutines_coreFlow>)receiver scope:(id<MPKKotlinx_coroutines_coreCoroutineScope>)scope __attribute__((swift_name("safeLaunchIn(_:scope:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DataModuleKt")))
@interface MPKDataModuleKt : MPKBase
@property (class, readonly) MPKKoin_coreModule *dataModule __attribute__((swift_name("dataModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UserModuleKt")))
@interface MPKUserModuleKt : MPKBase
@property (class, readonly) MPKKoin_coreModule *userModule __attribute__((swift_name("userModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoin")))
@interface MPKKoin_coreKoin : MPKBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)close __attribute__((swift_name("close()")));
- (void)createEagerInstances __attribute__((swift_name("createEagerInstances()")));
- (MPKKoin_coreScope *)createScopeT:(id<MPKKoin_coreKoinScopeComponent>)t __attribute__((swift_name("createScope(t:)")));
- (MPKKoin_coreScope *)createScopeScopeId:(NSString *)scopeId __attribute__((swift_name("createScope(scopeId:)")));
- (MPKKoin_coreScope *)createScopeScopeId:(NSString *)scopeId source:(id _Nullable)source __attribute__((swift_name("createScope(scopeId:source:)")));
- (MPKKoin_coreScope *)createScopeScopeId:(NSString *)scopeId qualifier:(id<MPKKoin_coreQualifier>)qualifier source:(id _Nullable)source __attribute__((swift_name("createScope(scopeId:qualifier:source:)")));
- (void)declareInstance:(id _Nullable)instance qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier secondaryTypes:(NSArray<id<MPKKotlinKClass>> *)secondaryTypes allowOverride:(BOOL)allowOverride __attribute__((swift_name("declare(instance:qualifier:secondaryTypes:allowOverride:)")));
- (void)deletePropertyKey:(NSString *)key __attribute__((swift_name("deleteProperty(key:)")));
- (void)deleteScopeScopeId:(NSString *)scopeId __attribute__((swift_name("deleteScope(scopeId:)")));
- (id _Nullable)getClazz:(id<MPKKotlinKClass>)clazz qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(clazz:qualifier:parameters:)")));
- (id)getQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(qualifier:parameters:)")));
- (NSArray<id> *)getAll __attribute__((swift_name("getAll()")));
- (MPKKoin_coreScope *)getOrCreateScopeScopeId:(NSString *)scopeId __attribute__((swift_name("getOrCreateScope(scopeId:)")));
- (MPKKoin_coreScope *)getOrCreateScopeScopeId:(NSString *)scopeId qualifier:(id<MPKKoin_coreQualifier>)qualifier source:(id _Nullable)source __attribute__((swift_name("getOrCreateScope(scopeId:qualifier:source:)")));
- (id _Nullable)getOrNullClazz:(id<MPKKotlinKClass>)clazz qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(clazz:qualifier:parameters:)")));
- (id _Nullable)getOrNullQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(qualifier:parameters:)")));
- (id _Nullable)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (id)getPropertyKey:(NSString *)key defaultValue:(id)defaultValue __attribute__((swift_name("getProperty(key:defaultValue:)")));
- (MPKKoin_coreScope *)getScopeScopeId:(NSString *)scopeId __attribute__((swift_name("getScope(scopeId:)")));
- (MPKKoin_coreScope * _Nullable)getScopeOrNullScopeId:(NSString *)scopeId __attribute__((swift_name("getScopeOrNull(scopeId:)")));
- (id<MPKKotlinLazy>)injectQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier mode:(MPKKotlinLazyThreadSafetyMode *)mode parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("inject(qualifier:mode:parameters:)")));
- (id<MPKKotlinLazy>)injectOrNullQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier mode:(MPKKotlinLazyThreadSafetyMode *)mode parameters:(MPKKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("injectOrNull(qualifier:mode:parameters:)")));
- (void)loadModulesModules:(NSArray<MPKKoin_coreModule *> *)modules allowOverride:(BOOL)allowOverride __attribute__((swift_name("loadModules(modules:allowOverride:)")));
- (void)setPropertyKey:(NSString *)key value:(id)value __attribute__((swift_name("setProperty(key:value:)")));
- (void)setupLoggerLogger:(MPKKoin_coreLogger *)logger __attribute__((swift_name("setupLogger(logger:)")));
- (void)unloadModulesModules:(NSArray<MPKKoin_coreModule *> *)modules __attribute__((swift_name("unloadModules(modules:)")));
@property (readonly) MPKKoin_coreInstanceRegistry *instanceRegistry __attribute__((swift_name("instanceRegistry")));
@property (readonly) MPKKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) MPKKoin_corePropertyRegistry *propertyRegistry __attribute__((swift_name("propertyRegistry")));
@property (readonly) MPKKoin_coreScopeRegistry *scopeRegistry __attribute__((swift_name("scopeRegistry")));
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol MPKKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<MPKKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<MPKKotlinCoroutineContextElement> _Nullable)getKey:(id<MPKKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<MPKKotlinCoroutineContext>)minusKeyKey:(id<MPKKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<MPKKotlinCoroutineContext>)plusContext:(id<MPKKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol MPKKotlinCoroutineContextElement <MPKKotlinCoroutineContext>
@required
@property (readonly) id<MPKKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface MPKKotlinAbstractCoroutineContextElement : MPKBase <MPKKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<MPKKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (readonly) id<MPKKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol MPKKotlinContinuationInterceptor <MPKKotlinCoroutineContextElement>
@required
- (id<MPKKotlinContinuation>)interceptContinuationContinuation:(id<MPKKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<MPKKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher")))
@interface MPKKotlinx_coroutines_coreCoroutineDispatcher : MPKKotlinAbstractCoroutineContextElement <MPKKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<MPKKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) MPKKotlinx_coroutines_coreCoroutineDispatcherKey *companion __attribute__((swift_name("companion")));
- (void)dispatchContext:(id<MPKKotlinCoroutineContext>)context block:(id<MPKKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<MPKKotlinCoroutineContext>)context block:(id<MPKKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (id<MPKKotlinContinuation>)interceptContinuationContinuation:(id<MPKKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (BOOL)isDispatchNeededContext:(id<MPKKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));
- (MPKKotlinx_coroutines_coreCoroutineDispatcher *)limitedParallelismParallelism:(int32_t)parallelism __attribute__((swift_name("limitedParallelism(parallelism:)")));
- (MPKKotlinx_coroutines_coreCoroutineDispatcher *)plusOther:(MPKKotlinx_coroutines_coreCoroutineDispatcher *)other __attribute__((swift_name("plus(other:)"))) __attribute__((unavailable("Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")));
- (void)releaseInterceptedContinuationContinuation:(id<MPKKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol MPKKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<MPKKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface MPKKotlinThrowable : MPKBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (MPKKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end;

__attribute__((swift_name("KotlinException")))
@interface MPKKotlinException : MPKKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface MPKKotlinRuntimeException : MPKKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface MPKKotlinIllegalStateException : MPKKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCancellationException")))
@interface MPKKotlinCancellationException : MPKKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(MPKKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol MPKKotlinx_coroutines_coreFlow
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)collectCollector:(id<MPKKotlinx_coroutines_coreFlowCollector>)collector completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("collect(collector:completionHandler:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSharedFlow")))
@protocol MPKKotlinx_coroutines_coreSharedFlow <MPKKotlinx_coroutines_coreFlow>
@required
@property (readonly) NSArray<id> *replayCache __attribute__((swift_name("replayCache")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreStateFlow")))
@protocol MPKKotlinx_coroutines_coreStateFlow <MPKKotlinx_coroutines_coreSharedFlow>
@required
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface MPKKotlinNothing : MPKBase
@end;

__attribute__((swift_name("KermitLogger")))
@interface MPKKermitLogger : MPKBase
- (instancetype)initWithConfig:(id<MPKKermitLoggerConfig>)config tag:(NSString *)tag __attribute__((swift_name("init(config:tag:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKKermitLoggerCompanion *companion __attribute__((swift_name("companion")));
- (void)aMessage:(NSString *(^)(void))message __attribute__((swift_name("a(message:)")));
- (void)aMessage_:(NSString *)message __attribute__((swift_name("a(message_:)")));
- (void)aMessage:(NSString *)message throwable:(MPKKotlinThrowable *)throwable __attribute__((swift_name("a(message:throwable:)")));
- (void)aThrowable:(MPKKotlinThrowable *)throwable message:(NSString *(^)(void))message __attribute__((swift_name("a(throwable:message:)")));
- (void)dMessage:(NSString *(^)(void))message __attribute__((swift_name("d(message:)")));
- (void)dMessage_:(NSString *)message __attribute__((swift_name("d(message_:)")));
- (void)dMessage:(NSString *)message throwable:(MPKKotlinThrowable *)throwable __attribute__((swift_name("d(message:throwable:)")));
- (void)dThrowable:(MPKKotlinThrowable *)throwable message:(NSString *(^)(void))message __attribute__((swift_name("d(throwable:message:)")));
- (void)eMessage:(NSString *(^)(void))message __attribute__((swift_name("e(message:)")));
- (void)eMessage_:(NSString *)message __attribute__((swift_name("e(message_:)")));
- (void)eMessage:(NSString *)message throwable:(MPKKotlinThrowable *)throwable __attribute__((swift_name("e(message:throwable:)")));
- (void)eThrowable:(MPKKotlinThrowable *)throwable message:(NSString *(^)(void))message __attribute__((swift_name("e(throwable:message:)")));
- (void)iMessage:(NSString *(^)(void))message __attribute__((swift_name("i(message:)")));
- (void)iMessage_:(NSString *)message __attribute__((swift_name("i(message_:)")));
- (void)iMessage:(NSString *)message throwable:(MPKKotlinThrowable *)throwable __attribute__((swift_name("i(message:throwable:)")));
- (void)iThrowable:(MPKKotlinThrowable *)throwable message:(NSString *(^)(void))message __attribute__((swift_name("i(throwable:message:)")));
- (void)logSeverity:(MPKKermitSeverity *)severity tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable message:(NSString *)message __attribute__((swift_name("log(severity:tag:throwable:message:)")));
- (void)vMessage:(NSString *(^)(void))message __attribute__((swift_name("v(message:)")));
- (void)vMessage_:(NSString *)message __attribute__((swift_name("v(message_:)")));
- (void)vMessage:(NSString *)message throwable:(MPKKotlinThrowable *)throwable __attribute__((swift_name("v(message:throwable:)")));
- (void)vThrowable:(MPKKotlinThrowable *)throwable message:(NSString *(^)(void))message __attribute__((swift_name("v(throwable:message:)")));
- (void)wMessage:(NSString *(^)(void))message __attribute__((swift_name("w(message:)")));
- (void)wMessage_:(NSString *)message __attribute__((swift_name("w(message_:)")));
- (void)wMessage:(NSString *)message throwable:(MPKKotlinThrowable *)throwable __attribute__((swift_name("w(message:throwable:)")));
- (void)wThrowable:(MPKKotlinThrowable *)throwable message:(NSString *(^)(void))message __attribute__((swift_name("w(throwable:message:)")));
- (MPKKermitLogger *)withTagTag:(NSString *)tag __attribute__((swift_name("withTag(tag:)")));
@property (readonly) id<MPKKermitLoggerConfig> config __attribute__((swift_name("config")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end;

__attribute__((swift_name("Multiplatform_settingsSettings")))
@protocol MPKMultiplatform_settingsSettings
@required
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)getBooleanKey:(NSString *)key defaultValue:(BOOL)defaultValue __attribute__((swift_name("getBoolean(key:defaultValue:)")));
- (MPKBoolean * _Nullable)getBooleanOrNullKey:(NSString *)key __attribute__((swift_name("getBooleanOrNull(key:)")));
- (double)getDoubleKey:(NSString *)key defaultValue:(double)defaultValue __attribute__((swift_name("getDouble(key:defaultValue:)")));
- (MPKDouble * _Nullable)getDoubleOrNullKey:(NSString *)key __attribute__((swift_name("getDoubleOrNull(key:)")));
- (float)getFloatKey:(NSString *)key defaultValue:(float)defaultValue __attribute__((swift_name("getFloat(key:defaultValue:)")));
- (MPKFloat * _Nullable)getFloatOrNullKey:(NSString *)key __attribute__((swift_name("getFloatOrNull(key:)")));
- (int32_t)getIntKey:(NSString *)key defaultValue:(int32_t)defaultValue __attribute__((swift_name("getInt(key:defaultValue:)")));
- (MPKInt * _Nullable)getIntOrNullKey:(NSString *)key __attribute__((swift_name("getIntOrNull(key:)")));
- (int64_t)getLongKey:(NSString *)key defaultValue:(int64_t)defaultValue __attribute__((swift_name("getLong(key:defaultValue:)")));
- (MPKLong * _Nullable)getLongOrNullKey:(NSString *)key __attribute__((swift_name("getLongOrNull(key:)")));
- (NSString *)getStringKey:(NSString *)key defaultValue:(NSString *)defaultValue __attribute__((swift_name("getString(key:defaultValue:)")));
- (NSString * _Nullable)getStringOrNullKey:(NSString *)key __attribute__((swift_name("getStringOrNull(key:)")));
- (BOOL)hasKeyKey:(NSString *)key __attribute__((swift_name("hasKey(key:)")));
- (void)putBooleanKey:(NSString *)key value:(BOOL)value __attribute__((swift_name("putBoolean(key:value:)")));
- (void)putDoubleKey:(NSString *)key value:(double)value __attribute__((swift_name("putDouble(key:value:)")));
- (void)putFloatKey:(NSString *)key value:(float)value __attribute__((swift_name("putFloat(key:value:)")));
- (void)putIntKey:(NSString *)key value:(int32_t)value __attribute__((swift_name("putInt(key:value:)")));
- (void)putLongKey:(NSString *)key value:(int64_t)value __attribute__((swift_name("putLong(key:value:)")));
- (void)putStringKey:(NSString *)key value:(NSString *)value __attribute__((swift_name("putString(key:value:)")));
- (void)removeKey:(NSString *)key __attribute__((swift_name("remove(key:)")));
@property (readonly) NSSet<NSString *> *keys __attribute__((swift_name("keys")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol MPKKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<MPKKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<MPKKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol MPKKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<MPKKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<MPKKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol MPKKotlinx_serialization_coreKSerializer <MPKKotlinx_serialization_coreSerializationStrategy, MPKKotlinx_serialization_coreDeserializationStrategy>
@required
@end;

__attribute__((swift_name("Koin_coreQualifier")))
@protocol MPKKoin_coreQualifier
@required
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol MPKKotlinKDeclarationContainer
@required
@end;

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol MPKKotlinKAnnotatedElement
@required
@end;

__attribute__((swift_name("KotlinKClassifier")))
@protocol MPKKotlinKClassifier
@required
@end;

__attribute__((swift_name("KotlinKClass")))
@protocol MPKKotlinKClass <MPKKotlinKDeclarationContainer, MPKKotlinKAnnotatedElement, MPKKotlinKClassifier>
@required
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end;

__attribute__((swift_name("Koin_coreParametersHolder")))
@interface MPKKoin_coreParametersHolder : MPKBase
- (instancetype)initWith_values:(NSMutableArray<id> *)_values __attribute__((swift_name("init(_values:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKKoin_coreParametersHolderCompanion *companion __attribute__((swift_name("companion")));
- (MPKKoin_coreParametersHolder *)addValue:(id)value __attribute__((swift_name("add(value:)")));
- (id _Nullable)component1 __attribute__((swift_name("component1()")));
- (id _Nullable)component2 __attribute__((swift_name("component2()")));
- (id _Nullable)component3 __attribute__((swift_name("component3()")));
- (id _Nullable)component4 __attribute__((swift_name("component4()")));
- (id _Nullable)component5 __attribute__((swift_name("component5()")));
- (id _Nullable)elementAtI:(int32_t)i clazz:(id<MPKKotlinKClass>)clazz __attribute__((swift_name("elementAt(i:clazz:)")));
- (id)get __attribute__((swift_name("get()")));
- (id _Nullable)getI:(int32_t)i __attribute__((swift_name("get(i:)")));
- (id _Nullable)getOrNull __attribute__((swift_name("getOrNull()")));
- (id _Nullable)getOrNullClazz:(id<MPKKotlinKClass>)clazz __attribute__((swift_name("getOrNull(clazz:)")));
- (MPKKoin_coreParametersHolder *)insertIndex:(int32_t)index value:(id)value __attribute__((swift_name("insert(index:value:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (BOOL)isNotEmpty __attribute__((swift_name("isNotEmpty()")));
- (void)setI:(int32_t)i t:(id _Nullable)t __attribute__((swift_name("set(i:t:)")));
- (int32_t)size_ __attribute__((swift_name("size()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<id> *values __attribute__((swift_name("values")));
@end;

__attribute__((swift_name("KotlinLazy")))
@protocol MPKKotlinLazy
@required
- (BOOL)isInitialized __attribute__((swift_name("isInitialized()")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("KotlinEnum")))
@interface MPKKotlinEnum<E> : MPKBase <MPKKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinLazyThreadSafetyMode")))
@interface MPKKotlinLazyThreadSafetyMode : MPKKotlinEnum<MPKKotlinLazyThreadSafetyMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) MPKKotlinLazyThreadSafetyMode *synchronized __attribute__((swift_name("synchronized")));
@property (class, readonly) MPKKotlinLazyThreadSafetyMode *publication __attribute__((swift_name("publication")));
@property (class, readonly) MPKKotlinLazyThreadSafetyMode *none __attribute__((swift_name("none")));
+ (MPKKotlinArray<MPKKotlinLazyThreadSafetyMode *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface MPKKotlinArray<T> : MPKBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(MPKInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<MPKKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Koin_coreScopeCallback")))
@protocol MPKKoin_coreScopeCallback
@required
- (void)onScopeCloseScope:(MPKKoin_coreScope *)scope __attribute__((swift_name("onScopeClose(scope:)")));
@end;

__attribute__((swift_name("Koin_coreLogger")))
@interface MPKKoin_coreLogger : MPKBase
- (instancetype)initWithLevel:(MPKKoin_coreLevel *)level __attribute__((swift_name("init(level:)"))) __attribute__((objc_designated_initializer));
- (void)debugMsg:(NSString *)msg __attribute__((swift_name("debug(msg:)")));
- (void)errorMsg:(NSString *)msg __attribute__((swift_name("error(msg:)")));
- (void)infoMsg:(NSString *)msg __attribute__((swift_name("info(msg:)")));
- (BOOL)isAtLvl:(MPKKoin_coreLevel *)lvl __attribute__((swift_name("isAt(lvl:)")));
- (void)logLvl:(MPKKoin_coreLevel *)lvl msg:(NSString *(^)(void))msg __attribute__((swift_name("log(lvl:msg:)")));
- (void)logLevel:(MPKKoin_coreLevel *)level msg:(NSString *)msg __attribute__((swift_name("log(level:msg:)")));
@property MPKKoin_coreLevel *level __attribute__((swift_name("level")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeMonth")))
@interface MPKKotlinx_datetimeMonth : MPKKotlinEnum<MPKKotlinx_datetimeMonth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) MPKKotlinx_datetimeMonth *january __attribute__((swift_name("january")));
@property (class, readonly) MPKKotlinx_datetimeMonth *february __attribute__((swift_name("february")));
@property (class, readonly) MPKKotlinx_datetimeMonth *march __attribute__((swift_name("march")));
@property (class, readonly) MPKKotlinx_datetimeMonth *april __attribute__((swift_name("april")));
@property (class, readonly) MPKKotlinx_datetimeMonth *may __attribute__((swift_name("may")));
@property (class, readonly) MPKKotlinx_datetimeMonth *june __attribute__((swift_name("june")));
@property (class, readonly) MPKKotlinx_datetimeMonth *july __attribute__((swift_name("july")));
@property (class, readonly) MPKKotlinx_datetimeMonth *august __attribute__((swift_name("august")));
@property (class, readonly) MPKKotlinx_datetimeMonth *september __attribute__((swift_name("september")));
@property (class, readonly) MPKKotlinx_datetimeMonth *october __attribute__((swift_name("october")));
@property (class, readonly) MPKKotlinx_datetimeMonth *november __attribute__((swift_name("november")));
@property (class, readonly) MPKKotlinx_datetimeMonth *december __attribute__((swift_name("december")));
+ (MPKKotlinArray<MPKKotlinx_datetimeMonth *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDate.Companion")))
@interface MPKKotlinx_datetimeLocalDateCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKotlinx_datetimeLocalDateCompanion *shared __attribute__((swift_name("shared")));
- (MPKKotlinx_datetimeLocalDate *)fromEpochDaysEpochDays:(int32_t)epochDays __attribute__((swift_name("fromEpochDays(epochDays:)")));
- (MPKKotlinx_datetimeLocalDate *)parseIsoString:(NSString *)isoString __attribute__((swift_name("parse(isoString:)")));
- (id<MPKKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDayOfWeek")))
@interface MPKKotlinx_datetimeDayOfWeek : MPKKotlinEnum<MPKKotlinx_datetimeDayOfWeek *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) MPKKotlinx_datetimeDayOfWeek *monday __attribute__((swift_name("monday")));
@property (class, readonly) MPKKotlinx_datetimeDayOfWeek *tuesday __attribute__((swift_name("tuesday")));
@property (class, readonly) MPKKotlinx_datetimeDayOfWeek *wednesday __attribute__((swift_name("wednesday")));
@property (class, readonly) MPKKotlinx_datetimeDayOfWeek *thursday __attribute__((swift_name("thursday")));
@property (class, readonly) MPKKotlinx_datetimeDayOfWeek *friday __attribute__((swift_name("friday")));
@property (class, readonly) MPKKotlinx_datetimeDayOfWeek *saturday __attribute__((swift_name("saturday")));
@property (class, readonly) MPKKotlinx_datetimeDayOfWeek *sunday __attribute__((swift_name("sunday")));
+ (MPKKotlinArray<MPKKotlinx_datetimeDayOfWeek *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoinApplication")))
@interface MPKKoin_coreKoinApplication : MPKBase
@property (class, readonly, getter=companion) MPKKoin_coreKoinApplicationCompanion *companion __attribute__((swift_name("companion")));
- (void)allowOverrideOverride:(BOOL)override __attribute__((swift_name("allowOverride(override:)")));
- (void)close __attribute__((swift_name("close()")));
- (void)createEagerInstances __attribute__((swift_name("createEagerInstances()")));
- (MPKKoin_coreKoinApplication *)loggerLogger:(MPKKoin_coreLogger *)logger __attribute__((swift_name("logger(logger:)")));
- (MPKKoin_coreKoinApplication *)modulesModules:(MPKKotlinArray<MPKKoin_coreModule *> *)modules __attribute__((swift_name("modules(modules:)")));
- (MPKKoin_coreKoinApplication *)modulesModules_:(NSArray<MPKKoin_coreModule *> *)modules __attribute__((swift_name("modules(modules_:)")));
- (MPKKoin_coreKoinApplication *)modulesModules__:(MPKKoin_coreModule *)modules __attribute__((swift_name("modules(modules__:)")));
- (MPKKoin_coreKoinApplication *)printLoggerLevel:(MPKKoin_coreLevel *)level __attribute__((swift_name("printLogger(level:)")));
- (MPKKoin_coreKoinApplication *)propertiesValues:(NSDictionary<NSString *, id> *)values __attribute__((swift_name("properties(values:)")));
- (void)unloadModulesModules:(NSArray<MPKKoin_coreModule *> *)modules __attribute__((swift_name("unloadModules(modules:)")));
- (void)unloadModulesModule:(MPKKoin_coreModule *)module __attribute__((swift_name("unloadModules(module:)")));
@property (readonly) MPKKoin_coreKoin *koin __attribute__((swift_name("koin")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreModule")))
@interface MPKKoin_coreModule : MPKBase
- (instancetype)initWith_createdAtStart:(BOOL)_createdAtStart __attribute__((swift_name("init(_createdAtStart:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (MPKKotlinPair<MPKKoin_coreModule *, MPKKoin_coreInstanceFactory<id> *> *)factoryQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))definition __attribute__((swift_name("factory(qualifier:definition:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (void)includesModule:(MPKKotlinArray<MPKKoin_coreModule *> *)module __attribute__((swift_name("includes(module:)")));
- (void)includesModule_:(NSArray<MPKKoin_coreModule *> *)module __attribute__((swift_name("includes(module_:)")));
- (NSArray<MPKKoin_coreModule *> *)plusModules:(NSArray<MPKKoin_coreModule *> *)modules __attribute__((swift_name("plus(modules:)")));
- (NSArray<MPKKoin_coreModule *> *)plusModule:(MPKKoin_coreModule *)module __attribute__((swift_name("plus(module:)")));
- (void)scopeQualifier:(id<MPKKoin_coreQualifier>)qualifier scopeSet:(void (^)(MPKKoin_coreScopeDSL *))scopeSet __attribute__((swift_name("scope(qualifier:scopeSet:)")));
- (void)scopeScopeSet:(void (^)(MPKKoin_coreScopeDSL *))scopeSet __attribute__((swift_name("scope(scopeSet:)")));
- (MPKKotlinPair<MPKKoin_coreModule *, MPKKoin_coreInstanceFactory<id> *> *)singleQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier createdAtStart:(BOOL)createdAtStart definition:(id _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))definition __attribute__((swift_name("single(qualifier:createdAtStart:definition:)")));
@property (readonly) MPKMutableSet<MPKKoin_coreSingleInstanceFactory<id> *> *eagerInstances __attribute__((swift_name("eagerInstances")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) BOOL isLoaded __attribute__((swift_name("isLoaded")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinRegex")))
@interface MPKKotlinRegex : MPKBase
- (instancetype)initWithPattern:(NSString *)pattern __attribute__((swift_name("init(pattern:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPattern:(NSString *)pattern option:(MPKKotlinRegexOption *)option __attribute__((swift_name("init(pattern:option:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPattern:(NSString *)pattern options:(NSSet<MPKKotlinRegexOption *> *)options __attribute__((swift_name("init(pattern:options:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKKotlinRegexCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)containsMatchInInput:(id)input __attribute__((swift_name("containsMatchIn(input:)")));
- (id<MPKKotlinMatchResult> _Nullable)findInput:(id)input startIndex:(int32_t)startIndex __attribute__((swift_name("find(input:startIndex:)")));
- (id<MPKKotlinSequence>)findAllInput:(id)input startIndex:(int32_t)startIndex __attribute__((swift_name("findAll(input:startIndex:)")));
- (id<MPKKotlinMatchResult> _Nullable)matchAtInput:(id)input index:(int32_t)index __attribute__((swift_name("matchAt(input:index:)")));
- (id<MPKKotlinMatchResult> _Nullable)matchEntireInput:(id)input __attribute__((swift_name("matchEntire(input:)")));
- (BOOL)matchesInput:(id)input __attribute__((swift_name("matches(input:)")));
- (BOOL)matchesAtInput:(id)input index:(int32_t)index __attribute__((swift_name("matchesAt(input:index:)")));
- (NSString *)replaceInput:(id)input transform:(id (^)(id<MPKKotlinMatchResult>))transform __attribute__((swift_name("replace(input:transform:)")));
- (NSString *)replaceInput:(id)input replacement:(NSString *)replacement __attribute__((swift_name("replace(input:replacement:)")));
- (NSString *)replaceFirstInput:(id)input replacement:(NSString *)replacement __attribute__((swift_name("replaceFirst(input:replacement:)")));
- (NSArray<NSString *> *)splitInput:(id)input limit:(int32_t)limit __attribute__((swift_name("split(input:limit:)")));
- (id<MPKKotlinSequence>)splitToSequenceInput:(id)input limit:(int32_t)limit __attribute__((swift_name("splitToSequence(input:limit:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSSet<MPKKotlinRegexOption *> *options __attribute__((swift_name("options")));
@property (readonly) NSString *pattern __attribute__((swift_name("pattern")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreJob")))
@protocol MPKKotlinx_coroutines_coreJob <MPKKotlinCoroutineContextElement>
@required
- (id<MPKKotlinx_coroutines_coreChildHandle>)attachChildChild:(id<MPKKotlinx_coroutines_coreChildJob>)child __attribute__((swift_name("attachChild(child:)")));
- (void)cancelCause:(MPKKotlinCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (MPKKotlinCancellationException *)getCancellationException __attribute__((swift_name("getCancellationException()")));
- (id<MPKKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionOnCancelling:(BOOL)onCancelling invokeImmediately:(BOOL)invokeImmediately handler:(void (^)(MPKKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(onCancelling:invokeImmediately:handler:)")));
- (id<MPKKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionHandler:(void (^)(MPKKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(handler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)joinWithCompletionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("join(completionHandler:)")));
- (id<MPKKotlinx_coroutines_coreJob>)plusOther_:(id<MPKKotlinx_coroutines_coreJob>)other __attribute__((swift_name("plus(other_:)"))) __attribute__((unavailable("Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")));
- (BOOL)start __attribute__((swift_name("start()")));
@property (readonly) id<MPKKotlinSequence> children __attribute__((swift_name("children")));
@property (readonly) BOOL isActive __attribute__((swift_name("isActive")));
@property (readonly) BOOL isCancelled __attribute__((swift_name("isCancelled")));
@property (readonly) BOOL isCompleted __attribute__((swift_name("isCompleted")));
@property (readonly) id<MPKKotlinx_coroutines_coreSelectClause0> onJoin __attribute__((swift_name("onJoin")));
@end;

__attribute__((swift_name("KotlinFunction")))
@protocol MPKKotlinFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction1")))
@protocol MPKKotlinSuspendFunction1 <MPKKotlinFunction>
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeP1:(id _Nullable)p1 completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(p1:completionHandler:)")));
@end;

__attribute__((swift_name("Koin_coreKoinScopeComponent")))
@protocol MPKKoin_coreKoinScopeComponent <MPKKoin_coreKoinComponent>
@required
- (void)closeScope __attribute__((swift_name("closeScope()")));
@property (readonly) MPKKoin_coreScope *scope __attribute__((swift_name("scope")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceRegistry")))
@interface MPKKoin_coreInstanceRegistry : MPKBase
- (instancetype)initWith_koin:(MPKKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)saveMappingAllowOverride:(BOOL)allowOverride mapping:(NSString *)mapping factory:(MPKKoin_coreInstanceFactory<id> *)factory logWarning:(BOOL)logWarning __attribute__((swift_name("saveMapping(allowOverride:mapping:factory:logWarning:)")));
- (int32_t)size __attribute__((swift_name("size()")));
@property (readonly) MPKKoin_coreKoin *_koin __attribute__((swift_name("_koin")));
@property (readonly) NSDictionary<NSString *, MPKKoin_coreInstanceFactory<id> *> *instances __attribute__((swift_name("instances")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_corePropertyRegistry")))
@interface MPKKoin_corePropertyRegistry : MPKBase
- (instancetype)initWith_koin:(MPKKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (void)deletePropertyKey:(NSString *)key __attribute__((swift_name("deleteProperty(key:)")));
- (id _Nullable)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (void)savePropertiesProperties:(NSDictionary<NSString *, id> *)properties __attribute__((swift_name("saveProperties(properties:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeRegistry")))
@interface MPKKoin_coreScopeRegistry : MPKBase
- (instancetype)initWith_koin:(MPKKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKKoin_coreScopeRegistryCompanion *companion __attribute__((swift_name("companion")));
- (void)loadScopesModules:(NSSet<MPKKoin_coreModule *> *)modules __attribute__((swift_name("loadScopes(modules:)")));
@property (readonly) MPKKoin_coreScope *rootScope __attribute__((swift_name("rootScope")));
@property (readonly) NSSet<id<MPKKoin_coreQualifier>> *scopeDefinitions __attribute__((swift_name("scopeDefinitions")));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol MPKKotlinCoroutineContextKey
@required
@end;

__attribute__((swift_name("KotlinContinuation")))
@protocol MPKKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<MPKKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextKey")))
@interface MPKKotlinAbstractCoroutineContextKey<B, E> : MPKBase <MPKKotlinCoroutineContextKey>
- (instancetype)initWithBaseKey:(id<MPKKotlinCoroutineContextKey>)baseKey safeCast:(E _Nullable (^)(id<MPKKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher.Key")))
@interface MPKKotlinx_coroutines_coreCoroutineDispatcherKey : MPKKotlinAbstractCoroutineContextKey<id<MPKKotlinContinuationInterceptor>, MPKKotlinx_coroutines_coreCoroutineDispatcher *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithBaseKey:(id<MPKKotlinCoroutineContextKey>)baseKey safeCast:(id<MPKKotlinCoroutineContextElement> _Nullable (^)(id<MPKKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)key __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKotlinx_coroutines_coreCoroutineDispatcherKey *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreRunnable")))
@protocol MPKKotlinx_coroutines_coreRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlowCollector")))
@protocol MPKKotlinx_coroutines_coreFlowCollector
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)emitValue:(id _Nullable)value completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("emit(value:completionHandler:)")));
@end;

__attribute__((swift_name("KermitLoggerConfig")))
@protocol MPKKermitLoggerConfig
@required
@property (readonly) NSArray<MPKKermitLogWriter *> *logWriterList __attribute__((swift_name("logWriterList")));
@property (readonly) MPKKermitSeverity *minSeverity __attribute__((swift_name("minSeverity")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KermitLogger.Companion")))
@interface MPKKermitLoggerCompanion : MPKKermitLogger
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithConfig:(id<MPKKermitLoggerConfig>)config tag:(NSString *)tag __attribute__((swift_name("init(config:tag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKermitLoggerCompanion *shared __attribute__((swift_name("shared")));
- (void)aTag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable message:(NSString *(^)(void))message __attribute__((swift_name("a(tag:throwable:message:)")));
- (void)addLogWriterLogWriter:(MPKKotlinArray<MPKKermitLogWriter *> *)logWriter __attribute__((swift_name("addLogWriter(logWriter:)")));
- (void)dTag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable message:(NSString *(^)(void))message __attribute__((swift_name("d(tag:throwable:message:)")));
- (void)eTag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable message:(NSString *(^)(void))message __attribute__((swift_name("e(tag:throwable:message:)")));
- (void)iTag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable message:(NSString *(^)(void))message __attribute__((swift_name("i(tag:throwable:message:)")));
- (void)setLogWritersLogWriter:(MPKKotlinArray<MPKKermitLogWriter *> *)logWriter __attribute__((swift_name("setLogWriters(logWriter:)")));
- (void)setLogWritersLogWriters:(NSArray<MPKKermitLogWriter *> *)logWriters __attribute__((swift_name("setLogWriters(logWriters:)")));
- (void)setMinSeveritySeverity:(MPKKermitSeverity *)severity __attribute__((swift_name("setMinSeverity(severity:)")));
- (void)setTagTag:(NSString *)tag __attribute__((swift_name("setTag(tag:)")));
- (void)vTag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable message:(NSString *(^)(void))message __attribute__((swift_name("v(tag:throwable:message:)")));
- (void)wTag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable message:(NSString *(^)(void))message __attribute__((swift_name("w(tag:throwable:message:)")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KermitSeverity")))
@interface MPKKermitSeverity : MPKKotlinEnum<MPKKermitSeverity *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) MPKKermitSeverity *verbose __attribute__((swift_name("verbose")));
@property (class, readonly) MPKKermitSeverity *debug __attribute__((swift_name("debug")));
@property (class, readonly) MPKKermitSeverity *info __attribute__((swift_name("info")));
@property (class, readonly) MPKKermitSeverity *warn __attribute__((swift_name("warn")));
@property (class, readonly) MPKKermitSeverity *error __attribute__((swift_name("error")));
@property (class, readonly) MPKKermitSeverity *assert __attribute__((swift_name("assert")));
+ (MPKKotlinArray<MPKKermitSeverity *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol MPKKotlinx_serialization_coreEncoder
@required
- (id<MPKKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<MPKKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<MPKKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSerializer:(id<MPKKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<MPKKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) MPKKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol MPKKotlinx_serialization_coreSerialDescriptor
@required
- (NSArray<id<MPKKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<MPKKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) NSArray<id<MPKKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));
@property (readonly) MPKKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol MPKKotlinx_serialization_coreDecoder
@required
- (id<MPKKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<MPKKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (MPKKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<MPKKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<MPKKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) MPKKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreParametersHolder.Companion")))
@interface MPKKoin_coreParametersHolderCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKoin_coreParametersHolderCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) int32_t MAX_PARAMS __attribute__((swift_name("MAX_PARAMS")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface MPKKotlinEnumCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol MPKKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreLevel")))
@interface MPKKoin_coreLevel : MPKKotlinEnum<MPKKoin_coreLevel *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) MPKKoin_coreLevel *debug __attribute__((swift_name("debug")));
@property (class, readonly) MPKKoin_coreLevel *info __attribute__((swift_name("info")));
@property (class, readonly) MPKKoin_coreLevel *error __attribute__((swift_name("error")));
@property (class, readonly) MPKKoin_coreLevel *none __attribute__((swift_name("none")));
+ (MPKKotlinArray<MPKKoin_coreLevel *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoinApplication.Companion")))
@interface MPKKoin_coreKoinApplicationCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKoin_coreKoinApplicationCompanion *shared __attribute__((swift_name("shared")));
- (MPKKoin_coreKoinApplication *)doInit __attribute__((swift_name("doInit()")));
@end;

__attribute__((swift_name("Koin_coreInstanceFactory")))
@interface MPKKoin_coreInstanceFactory<T> : MPKKoin_coreLockable
- (instancetype)initWithBeanDefinition:(MPKKoin_coreBeanDefinition<T> *)beanDefinition __attribute__((swift_name("init(beanDefinition:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@property (class, readonly, getter=companion) MPKKoin_coreInstanceFactoryCompanion *companion __attribute__((swift_name("companion")));
- (T _Nullable)createContext:(MPKKoin_coreInstanceContext *)context __attribute__((swift_name("create(context:)")));
- (void)dropScope:(MPKKoin_coreScope * _Nullable)scope __attribute__((swift_name("drop(scope:)")));
- (void)dropAll __attribute__((swift_name("dropAll()")));
- (T _Nullable)getContext:(MPKKoin_coreInstanceContext *)context __attribute__((swift_name("get(context:)")));
- (BOOL)isCreatedContext:(MPKKoin_coreInstanceContext * _Nullable)context __attribute__((swift_name("isCreated(context:)")));
@property (readonly) MPKKoin_coreBeanDefinition<T> *beanDefinition __attribute__((swift_name("beanDefinition")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinPair")))
@interface MPKKotlinPair<__covariant A, __covariant B> : MPKBase
- (instancetype)initWithFirst:(A _Nullable)first second:(B _Nullable)second __attribute__((swift_name("init(first:second:)"))) __attribute__((objc_designated_initializer));
- (A _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (B _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKotlinPair<A, B> *)doCopyFirst:(A _Nullable)first second:(B _Nullable)second __attribute__((swift_name("doCopy(first:second:)")));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@property (readonly) A _Nullable first __attribute__((swift_name("first")));
@property (readonly) B _Nullable second __attribute__((swift_name("second")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeDSL")))
@interface MPKKoin_coreScopeDSL : MPKBase
- (instancetype)initWithScopeQualifier:(id<MPKKoin_coreQualifier>)scopeQualifier module:(MPKKoin_coreModule *)module __attribute__((swift_name("init(scopeQualifier:module:)"))) __attribute__((objc_designated_initializer));
- (MPKKotlinPair<MPKKoin_coreModule *, MPKKoin_coreInstanceFactory<id> *> *)factoryQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))definition __attribute__((swift_name("factory(qualifier:definition:)")));
- (MPKKotlinPair<MPKKoin_coreModule *, MPKKoin_coreInstanceFactory<id> *> *)scopedQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))definition __attribute__((swift_name("scoped(qualifier:definition:)")));
- (MPKKotlinPair<MPKKoin_coreModule *, MPKKoin_coreInstanceFactory<id> *> *)singleQualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))definition __attribute__((swift_name("single(qualifier:definition:)"))) __attribute__((unavailable("Can't use Single in a scope. Use Scoped instead")));
@property (readonly) MPKKoin_coreModule *module __attribute__((swift_name("module")));
@property (readonly) id<MPKKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreSingleInstanceFactory")))
@interface MPKKoin_coreSingleInstanceFactory<T> : MPKKoin_coreInstanceFactory<T>
- (instancetype)initWithBeanDefinition:(MPKKoin_coreBeanDefinition<T> *)beanDefinition __attribute__((swift_name("init(beanDefinition:)"))) __attribute__((objc_designated_initializer));
- (T _Nullable)createContext:(MPKKoin_coreInstanceContext *)context __attribute__((swift_name("create(context:)")));
- (void)dropScope:(MPKKoin_coreScope * _Nullable)scope __attribute__((swift_name("drop(scope:)")));
- (void)dropAll __attribute__((swift_name("dropAll()")));
- (T _Nullable)getContext:(MPKKoin_coreInstanceContext *)context __attribute__((swift_name("get(context:)")));
- (BOOL)isCreatedContext:(MPKKoin_coreInstanceContext * _Nullable)context __attribute__((swift_name("isCreated(context:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinRegexOption")))
@interface MPKKotlinRegexOption : MPKKotlinEnum<MPKKotlinRegexOption *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) MPKKotlinRegexOption *ignoreCase __attribute__((swift_name("ignoreCase")));
@property (class, readonly) MPKKotlinRegexOption *multiline __attribute__((swift_name("multiline")));
@property (class, readonly) MPKKotlinRegexOption *literal __attribute__((swift_name("literal")));
@property (class, readonly) MPKKotlinRegexOption *unixLines __attribute__((swift_name("unixLines")));
@property (class, readonly) MPKKotlinRegexOption *comments __attribute__((swift_name("comments")));
@property (class, readonly) MPKKotlinRegexOption *dotMatchesAll __attribute__((swift_name("dotMatchesAll")));
@property (class, readonly) MPKKotlinRegexOption *canonEq __attribute__((swift_name("canonEq")));
+ (MPKKotlinArray<MPKKotlinRegexOption *> *)values __attribute__((swift_name("values()")));
@property (readonly) int32_t mask __attribute__((swift_name("mask")));
@property (readonly) int32_t value_ __attribute__((swift_name("value_")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinRegex.Companion")))
@interface MPKKotlinRegexCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKotlinRegexCompanion *shared __attribute__((swift_name("shared")));
- (NSString *)escapeLiteral:(NSString *)literal __attribute__((swift_name("escape(literal:)")));
- (NSString *)escapeReplacementLiteral:(NSString *)literal __attribute__((swift_name("escapeReplacement(literal:)")));
- (MPKKotlinRegex *)fromLiteralLiteral:(NSString *)literal __attribute__((swift_name("fromLiteral(literal:)")));
@end;

__attribute__((swift_name("KotlinMatchResult")))
@protocol MPKKotlinMatchResult
@required
- (id<MPKKotlinMatchResult> _Nullable)next __attribute__((swift_name("next()")));
@property (readonly) MPKKotlinMatchResultDestructured *destructured __attribute__((swift_name("destructured")));
@property (readonly) NSArray<NSString *> *groupValues __attribute__((swift_name("groupValues")));
@property (readonly) id<MPKKotlinMatchGroupCollection> groups __attribute__((swift_name("groups")));
@property (readonly) MPKKotlinIntRange *range __attribute__((swift_name("range")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("KotlinSequence")))
@protocol MPKKotlinSequence
@required
- (id<MPKKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreDisposableHandle")))
@protocol MPKKotlinx_coroutines_coreDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreChildHandle")))
@protocol MPKKotlinx_coroutines_coreChildHandle <MPKKotlinx_coroutines_coreDisposableHandle>
@required
- (BOOL)childCancelledCause:(MPKKotlinThrowable *)cause __attribute__((swift_name("childCancelled(cause:)")));
@property (readonly) id<MPKKotlinx_coroutines_coreJob> _Nullable parent __attribute__((swift_name("parent")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreChildJob")))
@protocol MPKKotlinx_coroutines_coreChildJob <MPKKotlinx_coroutines_coreJob>
@required
- (void)parentCancelledParentJob:(id<MPKKotlinx_coroutines_coreParentJob>)parentJob __attribute__((swift_name("parentCancelled(parentJob:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause0")))
@protocol MPKKotlinx_coroutines_coreSelectClause0
@required
- (void)registerSelectClause0Select:(id<MPKKotlinx_coroutines_coreSelectInstance>)select block:(id<MPKKotlinSuspendFunction0>)block __attribute__((swift_name("registerSelectClause0(select:block:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeRegistry.Companion")))
@interface MPKKoin_coreScopeRegistryCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKoin_coreScopeRegistryCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("KermitLogWriter")))
@interface MPKKermitLogWriter : MPKBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)aMessage:(NSString *)message tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable __attribute__((swift_name("a(message:tag:throwable:)")));
- (void)dMessage:(NSString *)message tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable __attribute__((swift_name("d(message:tag:throwable:)")));
- (void)eMessage:(NSString *)message tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable __attribute__((swift_name("e(message:tag:throwable:)")));
- (void)iMessage:(NSString *)message tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable __attribute__((swift_name("i(message:tag:throwable:)")));
- (BOOL)isLoggableSeverity:(MPKKermitSeverity *)severity __attribute__((swift_name("isLoggable(severity:)")));
- (void)logSeverity:(MPKKermitSeverity *)severity message:(NSString *)message tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable __attribute__((swift_name("log(severity:message:tag:throwable:)")));
- (void)vMessage:(NSString *)message tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable __attribute__((swift_name("v(message:tag:throwable:)")));
- (void)wMessage:(NSString *)message tag:(NSString *)tag throwable:(MPKKotlinThrowable * _Nullable)throwable __attribute__((swift_name("w(message:tag:throwable:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol MPKKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<MPKKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));
- (void)encodeNullableSerializableElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<MPKKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<MPKKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) MPKKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface MPKKotlinx_serialization_coreSerializersModule : MPKBase
- (void)dumpToCollector:(id<MPKKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));
- (id<MPKKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<MPKKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<MPKKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));
- (id<MPKKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<MPKKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));
- (id<MPKKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<MPKKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol MPKKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface MPKKotlinx_serialization_coreSerialKind : MPKBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol MPKKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<MPKKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<MPKKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<MPKKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<MPKKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) MPKKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreBeanDefinition")))
@interface MPKKoin_coreBeanDefinition<T> : MPKBase
- (instancetype)initWithScopeQualifier:(id<MPKKoin_coreQualifier>)scopeQualifier primaryType:(id<MPKKotlinKClass>)primaryType qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier definition:(T _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))definition kind:(MPKKoin_coreKind *)kind secondaryTypes:(NSArray<id<MPKKotlinKClass>> *)secondaryTypes __attribute__((swift_name("init(scopeQualifier:primaryType:qualifier:definition:kind:secondaryTypes:)"))) __attribute__((objc_designated_initializer));
- (id<MPKKoin_coreQualifier>)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (id<MPKKotlinKClass>)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (id<MPKKoin_coreQualifier> _Nullable)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (T _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKoin_coreKind *)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<id<MPKKotlinKClass>> *)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKoin_coreBeanDefinition<T> *)doCopyScopeQualifier:(id<MPKKoin_coreQualifier>)scopeQualifier primaryType:(id<MPKKotlinKClass>)primaryType qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier definition:(T _Nullable (^)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *))definition kind:(MPKKoin_coreKind *)kind secondaryTypes:(NSArray<id<MPKKotlinKClass>> *)secondaryTypes __attribute__((swift_name("doCopy(scopeQualifier:primaryType:qualifier:definition:kind:secondaryTypes:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (BOOL)hasTypeClazz:(id<MPKKotlinKClass>)clazz __attribute__((swift_name("hasType(clazz:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isClazz:(id<MPKKotlinKClass>)clazz qualifier:(id<MPKKoin_coreQualifier> _Nullable)qualifier scopeDefinition:(id<MPKKoin_coreQualifier>)scopeDefinition __attribute__((swift_name("is(clazz:qualifier:scopeDefinition:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property MPKKoin_coreCallbacks<T> *callbacks __attribute__((swift_name("callbacks")));
@property (readonly) T _Nullable (^definition)(MPKKoin_coreScope *, MPKKoin_coreParametersHolder *) __attribute__((swift_name("definition")));
@property (readonly) MPKKoin_coreKind *kind __attribute__((swift_name("kind")));
@property (readonly) id<MPKKotlinKClass> primaryType __attribute__((swift_name("primaryType")));
@property id<MPKKoin_coreQualifier> _Nullable qualifier __attribute__((swift_name("qualifier")));
@property (readonly) id<MPKKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@property NSArray<id<MPKKotlinKClass>> *secondaryTypes __attribute__((swift_name("secondaryTypes")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceFactoryCompanion")))
@interface MPKKoin_coreInstanceFactoryCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKoin_coreInstanceFactoryCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *ERROR_SEPARATOR __attribute__((swift_name("ERROR_SEPARATOR")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceContext")))
@interface MPKKoin_coreInstanceContext : MPKBase
- (instancetype)initWithKoin:(MPKKoin_coreKoin *)koin scope:(MPKKoin_coreScope *)scope parameters:(MPKKoin_coreParametersHolder * _Nullable)parameters __attribute__((swift_name("init(koin:scope:parameters:)"))) __attribute__((objc_designated_initializer));
@property (readonly) MPKKoin_coreKoin *koin __attribute__((swift_name("koin")));
@property (readonly) MPKKoin_coreParametersHolder * _Nullable parameters __attribute__((swift_name("parameters")));
@property (readonly) MPKKoin_coreScope *scope __attribute__((swift_name("scope")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinMatchResultDestructured")))
@interface MPKKotlinMatchResultDestructured : MPKBase
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component10 __attribute__((swift_name("component10()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (NSString *)component9 __attribute__((swift_name("component9()")));
- (NSArray<NSString *> *)toList __attribute__((swift_name("toList()")));
@property (readonly) id<MPKKotlinMatchResult> match __attribute__((swift_name("match")));
@end;

__attribute__((swift_name("KotlinIterable")))
@protocol MPKKotlinIterable
@required
- (id<MPKKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end;

__attribute__((swift_name("KotlinCollection")))
@protocol MPKKotlinCollection <MPKKotlinIterable>
@required
- (BOOL)containsElement:(id _Nullable)element __attribute__((swift_name("contains(element:)")));
- (BOOL)containsAllElements:(id)elements __attribute__((swift_name("containsAll(elements:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("KotlinMatchGroupCollection")))
@protocol MPKKotlinMatchGroupCollection <MPKKotlinCollection>
@required
- (MPKKotlinMatchGroup * _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
@end;

__attribute__((swift_name("KotlinIntProgression")))
@interface MPKKotlinIntProgression : MPKBase <MPKKotlinIterable>
@property (class, readonly, getter=companion) MPKKotlinIntProgressionCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (MPKKotlinIntIterator *)iterator __attribute__((swift_name("iterator()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t first __attribute__((swift_name("first")));
@property (readonly) int32_t last __attribute__((swift_name("last")));
@property (readonly) int32_t step __attribute__((swift_name("step")));
@end;

__attribute__((swift_name("KotlinClosedRange")))
@protocol MPKKotlinClosedRange
@required
- (BOOL)containsValue:(id)value __attribute__((swift_name("contains(value:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
@property (readonly) id endInclusive __attribute__((swift_name("endInclusive")));
@property (readonly, getter=start_) id start __attribute__((swift_name("start")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinIntRange")))
@interface MPKKotlinIntRange : MPKKotlinIntProgression <MPKKotlinClosedRange>
- (instancetype)initWithStart:(int32_t)start endInclusive:(int32_t)endInclusive __attribute__((swift_name("init(start:endInclusive:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) MPKKotlinIntRangeCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)containsValue:(MPKInt *)value __attribute__((swift_name("contains(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKInt *endInclusive __attribute__((swift_name("endInclusive")));
@property (readonly, getter=start_) MPKInt *start __attribute__((swift_name("start")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreParentJob")))
@protocol MPKKotlinx_coroutines_coreParentJob <MPKKotlinx_coroutines_coreJob>
@required
- (MPKKotlinCancellationException *)getChildJobCancellationCause __attribute__((swift_name("getChildJobCancellationCause()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectInstance")))
@protocol MPKKotlinx_coroutines_coreSelectInstance
@required
- (void)disposeOnSelectHandle:(id<MPKKotlinx_coroutines_coreDisposableHandle>)handle __attribute__((swift_name("disposeOnSelect(handle:)")));
- (id _Nullable)performAtomicTrySelectDesc:(MPKKotlinx_coroutines_coreAtomicDesc *)desc __attribute__((swift_name("performAtomicTrySelect(desc:)")));
- (void)resumeSelectWithExceptionException:(MPKKotlinThrowable *)exception __attribute__((swift_name("resumeSelectWithException(exception:)")));
- (BOOL)trySelect __attribute__((swift_name("trySelect()")));
- (id _Nullable)trySelectOtherOtherOp:(MPKKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp * _Nullable)otherOp __attribute__((swift_name("trySelectOther(otherOp:)")));
@property (readonly) id<MPKKotlinContinuation> completion __attribute__((swift_name("completion")));
@property (readonly) BOOL isSelected __attribute__((swift_name("isSelected")));
@end;

__attribute__((swift_name("KotlinSuspendFunction0")))
@protocol MPKKotlinSuspendFunction0 <MPKKotlinFunction>
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeWithCompletionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(completionHandler:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol MPKKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<MPKKotlinKClass>)kClass provider:(id<MPKKotlinx_serialization_coreKSerializer> (^)(NSArray<id<MPKKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<MPKKotlinKClass>)kClass serializer:(id<MPKKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<MPKKotlinKClass>)baseClass actualClass:(id<MPKKotlinKClass>)actualClass actualSerializer:(id<MPKKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<MPKKotlinKClass>)baseClass defaultDeserializerProvider:(id<MPKKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<MPKKotlinKClass>)baseClass defaultDeserializerProvider:(id<MPKKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<MPKKotlinKClass>)baseClass defaultSerializerProvider:(id<MPKKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKind")))
@interface MPKKoin_coreKind : MPKKotlinEnum<MPKKoin_coreKind *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) MPKKoin_coreKind *singleton __attribute__((swift_name("singleton")));
@property (class, readonly) MPKKoin_coreKind *factory __attribute__((swift_name("factory")));
@property (class, readonly) MPKKoin_coreKind *scoped __attribute__((swift_name("scoped")));
+ (MPKKotlinArray<MPKKoin_coreKind *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreCallbacks")))
@interface MPKKoin_coreCallbacks<T> : MPKBase
- (instancetype)initWithOnClose:(void (^ _Nullable)(T _Nullable))onClose __attribute__((swift_name("init(onClose:)"))) __attribute__((objc_designated_initializer));
- (void (^ _Nullable)(T _Nullable))component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKoin_coreCallbacks<T> *)doCopyOnClose:(void (^ _Nullable)(T _Nullable))onClose __attribute__((swift_name("doCopy(onClose:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) void (^ _Nullable onClose)(T _Nullable) __attribute__((swift_name("onClose")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinMatchGroup")))
@interface MPKKotlinMatchGroup : MPKBase
- (instancetype)initWithValue:(NSString *)value range:(MPKKotlinIntRange *)range __attribute__((swift_name("init(value:range:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKotlinIntRange *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (MPKKotlinMatchGroup *)doCopyValue:(NSString *)value range:(MPKKotlinIntRange *)range __attribute__((swift_name("doCopy(value:range:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKKotlinIntRange *range __attribute__((swift_name("range")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinIntProgression.Companion")))
@interface MPKKotlinIntProgressionCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKotlinIntProgressionCompanion *shared __attribute__((swift_name("shared")));
- (MPKKotlinIntProgression *)fromClosedRangeRangeStart:(int32_t)rangeStart rangeEnd:(int32_t)rangeEnd step:(int32_t)step __attribute__((swift_name("fromClosedRange(rangeStart:rangeEnd:step:)")));
@end;

__attribute__((swift_name("KotlinIntIterator")))
@interface MPKKotlinIntIterator : MPKBase <MPKKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (MPKInt *)next __attribute__((swift_name("next()")));
- (int32_t)nextInt __attribute__((swift_name("nextInt()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinIntRange.Companion")))
@interface MPKKotlinIntRangeCompanion : MPKBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MPKKotlinIntRangeCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) MPKKotlinIntRange *EMPTY __attribute__((swift_name("EMPTY")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicDesc")))
@interface MPKKotlinx_coroutines_coreAtomicDesc : MPKBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(MPKKotlinx_coroutines_coreAtomicOp<id> *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)prepareOp:(MPKKotlinx_coroutines_coreAtomicOp<id> *)op __attribute__((swift_name("prepare(op:)")));
@property MPKKotlinx_coroutines_coreAtomicOp<id> *atomicOp __attribute__((swift_name("atomicOp")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreOpDescriptor")))
@interface MPKKotlinx_coroutines_coreOpDescriptor : MPKBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (BOOL)isEarlierThanThat:(MPKKotlinx_coroutines_coreOpDescriptor *)that __attribute__((swift_name("isEarlierThan(that:)")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKKotlinx_coroutines_coreAtomicOp<id> * _Nullable atomicOp __attribute__((swift_name("atomicOp")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNode.PrepareOp")))
@interface MPKKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp : MPKKotlinx_coroutines_coreOpDescriptor
- (instancetype)initWithAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)next desc:(MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc *)desc __attribute__((swift_name("init(affected:next:desc:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)finishPrepare __attribute__((swift_name("finishPrepare()")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode *affected __attribute__((swift_name("affected")));
@property (readonly) MPKKotlinx_coroutines_coreAtomicOp<id> *atomicOp __attribute__((swift_name("atomicOp")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc *desc __attribute__((swift_name("desc")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode *next __attribute__((swift_name("next")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicOp")))
@interface MPKKotlinx_coroutines_coreAtomicOp<__contravariant T> : MPKKotlinx_coroutines_coreOpDescriptor
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeAffected:(T _Nullable)affected failure:(id _Nullable)failure __attribute__((swift_name("complete(affected:failure:)")));
- (id _Nullable)decideDecision:(id _Nullable)decision __attribute__((swift_name("decide(decision:)")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (id _Nullable)prepareAffected:(T _Nullable)affected __attribute__((swift_name("prepare(affected:)")));
@property (readonly) MPKKotlinx_coroutines_coreAtomicOp<id> *atomicOp __attribute__((swift_name("atomicOp")));
@property (readonly) id _Nullable consensus __attribute__((swift_name("consensus")));
@property (readonly) BOOL isDecided __attribute__((swift_name("isDecided")));
@property (readonly) int64_t opSequence __attribute__((swift_name("opSequence")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNode")))
@interface MPKKotlinx_coroutines_coreLockFreeLinkedListNode : MPKBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)addLastNode:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)node __attribute__((swift_name("addLast(node:)")));
- (BOOL)addLastIfNode:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)node condition:(MPKBoolean *(^)(void))condition __attribute__((swift_name("addLastIf(node:condition:)")));
- (BOOL)addLastIfPrevNode:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)node predicate:(MPKBoolean *(^)(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *))predicate __attribute__((swift_name("addLastIfPrev(node:predicate:)")));
- (BOOL)addLastIfPrevAndIfNode:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)node predicate:(MPKBoolean *(^)(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *))predicate condition:(MPKBoolean *(^)(void))condition __attribute__((swift_name("addLastIfPrevAndIf(node:predicate:condition:)")));
- (BOOL)addOneIfEmptyNode:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)node __attribute__((swift_name("addOneIfEmpty(node:)")));
- (MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc<MPKKotlinx_coroutines_coreLockFreeLinkedListNode *> *)describeAddLastNode:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)node __attribute__((swift_name("describeAddLast(node:)")));
- (MPKKotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc<MPKKotlinx_coroutines_coreLockFreeLinkedListNode *> *)describeRemoveFirst __attribute__((swift_name("describeRemoveFirst()")));
- (void)helpRemove __attribute__((swift_name("helpRemove()")));
- (MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)nextIfRemoved __attribute__((swift_name("nextIfRemoved()")));
- (BOOL)remove __attribute__((swift_name("remove()")));
- (id _Nullable)removeFirstIfIsInstanceOfOrPeekIfPredicate:(MPKBoolean *(^)(id _Nullable))predicate __attribute__((swift_name("removeFirstIfIsInstanceOfOrPeekIf(predicate:)")));
- (MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)removeFirstOrNull __attribute__((swift_name("removeFirstOrNull()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL isRemoved __attribute__((swift_name("isRemoved")));
@property (readonly, getter=next_) id next __attribute__((swift_name("next")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode *nextNode __attribute__((swift_name("nextNode")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode *prevNode __attribute__((swift_name("prevNode")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNode.AbstractAtomicDesc")))
@interface MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc : MPKKotlinx_coroutines_coreAtomicDesc
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(MPKKotlinx_coroutines_coreAtomicOp<id> *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)failureAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected __attribute__((swift_name("failure(affected:)")));
- (void)finishOnSuccessAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("finishOnSuccess(affected:next:)")));
- (void)finishPreparePrepareOp:(MPKKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("finishPrepare(prepareOp:)")));
- (id _Nullable)onPreparePrepareOp:(MPKKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("onPrepare(prepareOp:)")));
- (void)onRemovedAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected __attribute__((swift_name("onRemoved(affected:)")));
- (id _Nullable)prepareOp:(MPKKotlinx_coroutines_coreAtomicOp<id> *)op __attribute__((swift_name("prepare(op:)")));
- (BOOL)retryAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(id)next __attribute__((swift_name("retry(affected:next:)")));
- (MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)takeAffectedNodeOp:(MPKKotlinx_coroutines_coreOpDescriptor *)op __attribute__((swift_name("takeAffectedNode(op:)")));
- (id)updatedNextAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("updatedNext(affected:next:)")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable affectedNode __attribute__((swift_name("affectedNode")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable originalNext __attribute__((swift_name("originalNext")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc")))
@interface MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc<T> : MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc
- (instancetype)initWithQueue:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)queue node:(T)node __attribute__((swift_name("init(queue:node:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)finishOnSuccessAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("finishOnSuccess(affected:next:)")));
- (void)finishPreparePrepareOp:(MPKKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("finishPrepare(prepareOp:)")));
- (BOOL)retryAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(id)next __attribute__((swift_name("retry(affected:next:)")));
- (MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)takeAffectedNodeOp:(MPKKotlinx_coroutines_coreOpDescriptor *)op __attribute__((swift_name("takeAffectedNode(op:)")));
- (id)updatedNextAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("updatedNext(affected:next:)")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable affectedNode __attribute__((swift_name("affectedNode")));
@property (readonly) T node __attribute__((swift_name("node")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode *originalNext __attribute__((swift_name("originalNext")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode *queue __attribute__((swift_name("queue")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc")))
@interface MPKKotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc<T> : MPKKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc
- (instancetype)initWithQueue:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)queue __attribute__((swift_name("init(queue:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (id _Nullable)failureAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected __attribute__((swift_name("failure(affected:)")));
- (void)finishOnSuccessAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("finishOnSuccess(affected:next:)")));
- (void)finishPreparePrepareOp:(MPKKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("finishPrepare(prepareOp:)")));
- (BOOL)retryAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(id)next __attribute__((swift_name("retry(affected:next:)")));
- (MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)takeAffectedNodeOp:(MPKKotlinx_coroutines_coreOpDescriptor *)op __attribute__((swift_name("takeAffectedNode(op:)")));
- (id)updatedNextAffected:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(MPKKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("updatedNext(affected:next:)")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable affectedNode __attribute__((swift_name("affectedNode")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable originalNext __attribute__((swift_name("originalNext")));
@property (readonly) MPKKotlinx_coroutines_coreLockFreeLinkedListNode *queue __attribute__((swift_name("queue")));
@property (readonly) T _Nullable result __attribute__((swift_name("result")));
@end;

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
