package com.bronze.me.domain.interactor;


import com.bronze.me.domain.executor.PostExecutionThread;
import com.bronze.me.domain.executor.ThreadExecutor;
import com.bronze.me.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetUserListUseCase extends UseCase {

    private final UserRepository userRepository;

    @Inject
    public GetUserListUseCase(UserRepository userRepository, ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return this.userRepository.getUsers();
    }
}
