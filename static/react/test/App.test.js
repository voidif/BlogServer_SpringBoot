import App from '../src/App';
import React from 'react';
import { shallow } from 'enzyme';

describe('App', () => {
  test('should match snapshot', () => {
    const wrapper = shallow(<App />);

    expect(wrapper.find('p').text()).toBe('Hello World');
    expect(wrapper).toMatchSnapshot;
  });
});