import axios from 'axios';
import { put, takeLatest } from 'redux-saga/effects';

function* getToDos(action) {
    console.log('In getToDos');
    
    try {
        const response = yield axios({
            method: 'GET',
            url: ''
        })
        yield put({
            type: 'SET_TODOS',
            payload: response.data
        });
    } catch(err) {
        console.log('Error fetching ToDos', err);
    }
}
function* getToDosSaga() {
    yield takeLatest('GET_TODOS', getToDos);
}

export default getToDosSaga;