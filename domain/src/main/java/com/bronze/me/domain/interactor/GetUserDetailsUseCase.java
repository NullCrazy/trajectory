package com.bronze.me.domain.interactor;

import com.bronze.me.domain.executor.PostExecutionThread;
import com.bronze.me.domain.executor.ThreadExecutor;
import com.bronze.me.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an specific {@link User}.
 */
public class GetUserDetailsUseCase extends UseCase {

    private final int userId;
    private final UserRepository userRepository;

    @Inject
    public GetUserDetailsUseCase(int userId, UserRepository userRepository,
                                 ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userId = userId;
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.userRepository.getUser(this.userId);
    }
}
