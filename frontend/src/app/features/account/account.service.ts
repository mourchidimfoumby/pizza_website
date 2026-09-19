import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Account } from './account.model';
import { StorageService } from '../../shared/domain/storage.service';
import { User } from '../../shared/domain/entity/user.model';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  baseUrl = environment.apiUrl + '/accounts';
  httpClient = inject(HttpClient);
  storageService = inject(StorageService);

  public getAccount() {
    const user = this.storageService.get<User>('user');
    return this.httpClient.get<Account>(`${this.baseUrl}/${user?.id}`);
  }
}
