import { Component, inject, input } from '@angular/core';
import { AccountService } from '../account.service';
import { toSignal } from '@angular/core/rxjs-interop';

@Component({
  selector: 'app-account-info',
  imports: [],
  templateUrl: './account-info.html',
  styleUrl: './account-info.css',
})
export class AccountInfo {
  accountService = inject(AccountService);
  account = toSignal(this.accountService.getAccount());
}
