export type RequestState<T> =
  | { status: RequestStatus.LOADING }
  | { status: RequestStatus.SUCCESS; data: T }
  | { status: RequestStatus.ERROR; message: string };

export enum RequestStatus {
  LOADING,
  SUCCESS,
  ERROR
}
